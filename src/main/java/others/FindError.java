/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

package others;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import tools.engines.RestClient;

public class FindError{
    public static void main(String[]args) throws IOException{
        String fileName = "ErrorQuery.json";
        ClassLoader classLoader = new ReadResources().getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        //Read File Content
        String modelQuery = new String(file.toString());
        System.out.println();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter get service URL:\n" +
                "example: http://manage.dev1.riversand-dataplatform.com:8085/jcpenney/api/eventservice/get");
        String url = sc.next();
        System.out.println();

        System.out.println("Enter task ID:\n" +
                "example: df3a09f3-39d1-4fa9-8263-515dd84148dc");
        String taskId = sc.next();

        RestClient getRequester = new RestClient();
        Gson gson = new Gson();

        JsonObject requestPayload = FileHelper.readFileAsJson(modelQuery);

        JsonObject query = requestPayload.getAsJsonObject("params").getAsJsonObject("query").getAsJsonObject("filters").getAsJsonArray("attributesCriterion").get(0).getAsJsonObject().getAsJsonObject("taskId");
        query.addProperty("exact", taskId);

        String response = getRequester.sendRequest(url, requestPayload.toString());
        JsonObject responseData = gson.fromJson(response, JsonObject.class);

        boolean events = ((JsonObject) responseData.get("response")).has("events");

        if (events){
        System.out.println("");
        System.out.println("Entities Error Details:");
        System.out.println();
        String[] totalErrors = {"QUEUED_ERROR", "PROCESSING_START_ERROR", "PROCESSING_COMPLETE_ERROR", "PROCESSING_SUBMISSION_ERROR"};

        int count = 0;
        int valueSize = responseData.get("response").getAsJsonObject().getAsJsonArray("events").size();

            String resValue;
            String str;
            JsonObject type;
            JsonObject id;
            JsonObject errMessage;
            int no = 1;
            for (int a = 0; a < valueSize; a++){
                JsonObject value = (JsonObject) responseData.get("response").getAsJsonObject().getAsJsonArray("events").get(a).getAsJsonObject().get("data").getAsJsonObject().getAsJsonObject("attributes").get("eventSubType").getAsJsonObject().get("values").getAsJsonArray().get(0);
                resValue = value.get("value").toString();
                str = resValue.replace("\"", "");

                for (int x = 0; x < totalErrors.length; x++){
                    if (str.equals(totalErrors[x])){
                        id = responseData.get("response").getAsJsonObject().getAsJsonArray("events").get(a).getAsJsonObject();
                        System.out.println("Entity No." + no + ":");
                        System.out.println("");
                        System.out.println("Entity ID     = " + id.get("id"));
                        type = (JsonObject) responseData.get("response").getAsJsonObject().getAsJsonArray("events").get(a).getAsJsonObject().get("data").getAsJsonObject().getAsJsonObject("attributes").get("eventType").getAsJsonObject().get("values").getAsJsonArray().get(0);
                        System.out.println("Error  Layer  = " + type.get("value"));
                        System.out.println("Error  Type   = \"" + str + "\"");
                        errMessage = (JsonObject) responseData.get("response").getAsJsonObject().getAsJsonArray("events").get(a).getAsJsonObject().get("data").getAsJsonObject().getAsJsonObject("attributes").get("message").getAsJsonObject().get("values").getAsJsonArray().get(0);
                        System.out.println("Error Message = " + errMessage.get("value"));

                        System.out.println();
                        count++;
                        no++;
                    }
                }
            }
            if (count == 0){
                System.out.println("Entities are imported Successfully!!!");
            }
            else{
                System.out.println("No. of error entities : " + count);
            }
        }
        else{
            System.out.println();
            System.out.println("No objects found!");
            System.out.println("Verify URL or Task ID");
         }
    }
}