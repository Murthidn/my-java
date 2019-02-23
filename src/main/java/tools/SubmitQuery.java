/*
 *
 * Copyright (c) 2019 Riversand Technologies, Inc. All rights reserved.
 *
 */

package tools;

import others.*;
import tools.engines.*;

import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.common.collect.Iterables;

public class SubmitQuery {
   public static void main(String[] args) throws IOException {
      Scanner scanner = new Scanner(System.in);

      //Reading inputs
      System.out.println("Enter API URL:\n" +
            "example: http://{{WEBURL}}:{{WEBPORT}}/{{TENANT_ID}}/api/entityservice/get");
      String url = scanner.next();

      System.out.println("Input Query file path:\n" +
            "/var/lib/rs/dataplatform/scripts/getQuery.json");
      String getQuery = scanner.next();

      System.out.println("Enter IDs file path:\n" +
            "/var/lib/rs/dataplatform/scripts/idsFile.json");
      String idsFile = scanner.next();

      System.out.println("Enter output file path:\n" +
            "/var/lib/rs/dataplatform/scripts/outputFile");
      String outputFile = scanner.next();

      RestClient restClient = new RestClient();
      JsonArray responseArr = new JsonArray();
      JsonArray outputArray = new JsonArray();
      JsonObject outputData = new JsonObject();
      boolean isResponseError = false;

      //Preparing CSV Headers
      FileWriter writer = new FileWriter(outputFile + ".csv");
      writer.append("entityId");
      writer.append(',');
      writer.append("requestId");
      writer.append(',');
      writer.append("message");
      writer.append(',');
      writer.append("messageCode");
      writer.append(',');
      writer.append("messageType");
      writer.append('\n');

      try {
         String requestPayload = FileHelper.readFileAsString(getQuery);
         JsonObject requestJson = GsonBuilder.getGsonInstance().fromJson(requestPayload, JsonObject.class);

         JsonObject idsJsonFile = FileHelper.readFileAsJson(idsFile);
         JsonArray idsArray = idsJsonFile.getAsJsonArray("ids");
         int batchId = 1;

         for (List<JsonElement> batch : Iterables.partition(idsArray, 1)) {
            System.out.printf("Processing Query for batch %s \n", batchId + "/" + idsArray.size());

            for (JsonElement entity : batch) {
               requestJson.getAsJsonObject("entity").add("id", entity);
               String response = restClient.sendRequest(url, requestJson.toString());
               JsonObject responseData = GsonBuilder.getGsonInstance().fromJson(response, JsonObject.class);

               JsonObject processedEntity = new JsonObject();
               String getReqId = "";

               //Get Json Response (Entity Id and Request Id)
               if (responseData.getAsJsonObject("request").has("requestId")) {
                  getReqId = responseData.getAsJsonObject("request").get("requestId").getAsString();
                  processedEntity.addProperty("entityId", entity.getAsString());
                  processedEntity.addProperty("requestId", getReqId);

                  responseArr.add(processedEntity);
                  outputArray.addAll(responseArr);
               }

               //Get if response is error
               if (responseData.getAsJsonObject("response").get("status").getAsString().equalsIgnoreCase("error")) {
                  isResponseError = true;

                  if (responseData.getAsJsonObject("response").has("statusDetail") && responseData.getAsJsonObject("response").getAsJsonObject("statusDetail").has("messages")) {
                     JsonObject errMsgObj = responseData.getAsJsonObject("response").getAsJsonObject("statusDetail").getAsJsonArray("messages").get(0).getAsJsonObject();

                     String msg = "";
                     String msgCode = "";
                     String msgType = "";

                     if (errMsgObj.has("message")) {
                        msg = errMsgObj.get("message").getAsString();
                     }
                     if (errMsgObj.has("messageCode")) {
                        msgCode = errMsgObj.get("messageCode").getAsString();
                     }
                     if (errMsgObj.has("messageType")) {
                        msgType = errMsgObj.get("messageType").getAsString();
                     }

                     writer.append(entity.getAsString());
                     writer.append(',');
                     writer.append(getReqId);
                     writer.append(',');
                     writer.append(msg);
                     writer.append(',');
                     writer.append(msgCode);
                     writer.append(',');
                     writer.append(msgType);
                     writer.append('\n');
                  }
               }
            }
            batchId++;
         }

      } catch (Exception ex) {
         ex.printStackTrace();
      }

      //Write Json response
      boolean result;
      outputData.add("response", outputArray);
      result = others.FileHelper.writeJsonObjectToFile(outputFile + ".json", outputData);

      if (result) {
         System.out.println("Successfully wrote Json response to file- " + outputFile + ".json");
      } else {
         System.out.println("Failed to write response to file");
      }

      if (isResponseError) {
         System.out.println("Found Errors! wrote to file- " + outputFile + ".csv");
      }
      writer.flush();
      writer.close();

   }
}
