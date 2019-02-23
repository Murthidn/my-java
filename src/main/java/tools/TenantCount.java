/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

package tools;

import tools.engines.*;

import java.util.Scanner;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;

public class TenantCount {
   public static void main(String[] args) {
      RestClient getRequester = new RestClient();
      Scanner sc=new Scanner(System.in);

      //Input Files
      System.out.println("Enter URLs file path: \n");
      String urlListPath = sc.next();
      String tenantGetQuery = "{ \"params\": { \"query\": { \"filters\": { \"typesCriterion\": [ \"tenantserviceconfig\" ] } } } }";

      //Convert URL File to JSON Object
      JsonObject getUrlPath = others.FileHelper.readFileAsJson(urlListPath);
      JsonObject getUrlPathObj = GsonBuilder.getGsonInstance().fromJson(getUrlPath, JsonObject.class);

      //Convert Tenant Query File to JSON Object
      JsonObject getTenantQueryObj = GsonBuilder.getGsonInstance().fromJson(tenantGetQuery, JsonObject.class);

      //Get URL File Size
      JsonArray urlSize = getUrlPathObj.getAsJsonArray("url");


      //Start Printing
      System.out.println();
      System.out.println("=====================================================================================");
      System.out.println("All Tenant Names in "+urlSize.size()+" Environments.");
      System.out.println("-------------------------------------------------------------------------------------");
      System.out.println();
      int line=1;
      int tenantCount=0;
      int nonUrl=0;

      for (JsonElement getOneUrl : urlSize) {
         String oneUrl = getOneUrl.getAsString() + "dataplatform/api/configurationservice/get";
         String response = "";

         try {
            //Send Request
            response = getRequester.sendRequest(oneUrl, getTenantQueryObj.toString());
            JsonObject responseData = GsonBuilder.getGsonInstance().fromJson(response, JsonObject.class);

            System.out.println("[" + line + "] " + getOneUrl.getAsString());
            System.out.println();
            line++;

            JsonArray tenantList = responseData.getAsJsonObject("response").getAsJsonArray("configObjects");
            for (int j = 0; j < tenantList.size(); j++) {
               System.out.println(responseData.getAsJsonObject("response").getAsJsonArray("configObjects").get(j).getAsJsonObject().get("id").getAsString());
               tenantCount++;
            }

            System.out.println();
            System.out.println("=====================================================================================");
            System.out.println();
         }

         catch (Exception ex) {
            System.out.println("Hey Murthi, Below URL is Not Responding!");
            System.out.println();
            System.out.println("[" + line + "] " + oneUrl);
            System.out.println();
            System.out.println("=====================================================================================");
            System.out.println();
            line++;
            nonUrl++;
         }
      }

      int successUrl=urlSize.size()-nonUrl;
      System.out.println("Result:");
      System.out.println("Found "+tenantCount+" Tenants in "+urlSize.size()+" Environments!");
      System.out.println(nonUrl+" URL(s) are not Responding!");
      System.out.println(successUrl+" URLs are Successfully Responding!");
      System.out.println();
      System.out.println("Thank You!");
      System.out.println("-------------------------------------------------------------------------------------");
      System.out.println();
   }
}

