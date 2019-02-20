/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class GetResponse{
    public static void main(String[]args) throws IOException{
        Scanner sc = new Scanner((System.in));

        System.out.println("ENTER URL:");
        String url = sc.next();

        System.out.println("Enter Query File Path:");
        String queryFile = sc.next();

        System.out.println("Enter Output File Path:");
        String outputFile = sc.next();

        boolean firstWrite = true;
        System.out.println("Write to csv:\n" +
                "yes/no");
        Boolean writeCsv = sc.next().equalsIgnoreCase("yes") ? true : false;

        JsonObject requestPayload = FileHelper.readFileAsJson(queryFile);
        RestClient getRequester = new RestClient();
        Gson gson = new Gson();

        List<String> csvHeader = FileHelper.getCsvHeader(requestPayload);
        csvHeader.add("type");
        System.out.println(requestPayload);
        String response = getRequester.sendRequest(url, requestPayload.toString());
        JsonObject responseData = gson.fromJson(response, JsonObject.class);
        JsonArray outputArray = new JsonArray();

        JsonArray entities;
        JsonObject outputData = new JsonObject();

        if (responseData.has("response") &&
                responseData.getAsJsonObject("response").has("entities")
                && responseData.getAsJsonObject("response").getAsJsonArray("entities").size() > 0){
            entities = responseData.get("response").getAsJsonObject().getAsJsonArray("entities");

            if (writeCsv){
                boolean result = FileHelper.writeFromJsonToCSVFile(entities, outputFile + ".csv", csvHeader, firstWrite);
                if (result){
                    firstWrite = false;
                }
                else{
                    System.out.println("Failed to write entities to file");
                }
            }
            else{
                outputArray.add(entities);
            }

            if (!writeCsv){
                boolean result;
                outputData.add("entities", outputArray);
                result = FileHelper.writeJsonObjectToFile(outputFile + ".json", outputData);
                if (result){
                    System.out.println("Successfully wrote entities to file- " + outputFile);
                }
                else{
                    System.out.println("Failed to write ids to file");
                }
            }
        }
    }
}
