/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

package tools;

import java.util.Map;
import java.util.Scanner;
import java.io.IOException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import others.FileHelper;
import tools.engines.RestClient;
import tools.engines.GsonBuilder;

public class QuickLagReport {
   public static void main(String[] args) throws IOException {
      Scanner scanner=new Scanner(System.in);

      System.out.println("Enter Get Service URL:\n" +
            "example: http://{{WEBURL}}:{{WEBPORT}}/dataplatform/api/diagnosticservice/get");
      String url = scanner.next();

      System.out.println("Input get request file path:\n" +
            "/var/lib/rs/dataplatform/scripts/getLagQuery.json");
      String getLagFile = scanner.next();

      JsonObject requestPayload = FileHelper.readFileAsJson(getLagFile);
      String response = null;
      RestClient getRequester = new RestClient();

      JsonArray infoObjects;
      response = getRequester.sendRequest(url, requestPayload.toString());

      JsonObject responseData = GsonBuilder.getGsonInstance().fromJson(response, JsonObject.class);

      if (responseData.has("response") &&
            responseData.getAsJsonObject("response").has("infoObjects")
            && responseData.getAsJsonObject("response").getAsJsonArray("infoObjects").size() > 0) {
         infoObjects = responseData.get("response").getAsJsonObject().getAsJsonArray("infoObjects");

         for (JsonElement entity : infoObjects) {
            JsonObject entityObj = entity.getAsJsonObject();

            JsonObject attributesObj;
            if (entityObj.has("data") &&
                  entityObj.getAsJsonObject("data").has("attributes")) {
               attributesObj = entityObj.getAsJsonObject("data").getAsJsonObject("attributes");

               for (Map.Entry<String, JsonElement> entry : attributesObj.entrySet()) {

                  if (entry.getKey().equalsIgnoreCase("serviceName")){
                     //System.out.println("serviceName: " + entry.getValue().getAsJsonObject().getAsJsonArray("values").get(0).getAsJsonObject().get("value"));

                  }
                  else {
                     if (entry.getValue().getAsJsonObject().has("group")) {
                        JsonObject nestedAttr = entry.getValue().getAsJsonObject();

                        JsonArray nestedAttrs = nestedAttr.get("group").getAsJsonArray();

                        if (nestedAttrs.size() > 0) {
                           if (nestedAttrs.get(0).getAsJsonObject().has("lag")){

                              String lagValue = nestedAttrs.get(0).getAsJsonObject().getAsJsonObject("lag").getAsJsonArray("values").get(0).getAsJsonObject().get("value").getAsString();
                              System.out.println(entry.getKey() + " : "+lagValue);
                           }
                           /*else {
                              System.out.println("No lag element found!");
                           }*/

                        }
                        else {
                           System.out.println("No data in group!");
                        }
                     }
                     else {
                        System.out.println("No group found!");
                     }
                  }
               }
            }
         }
      }
      else {
         System.out.println("No Data Found!!!");
      }
   }
}


