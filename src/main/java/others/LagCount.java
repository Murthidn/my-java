/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

package others;

import java.util.Map;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;

public class LagCount{
    public static void main(String[]args){

        System.out.println("Enter File Path:");
        String secFile = "/home/murthidn/test.json";

        JsonObject requestPayload = FileHelper.readFileAsJson(secFile);
        JsonArray entities;
        int count=0;
        entities = requestPayload.getAsJsonObject("response").getAsJsonArray("infoObjects");

        for(int i=0;i<entities.size();i++){
            JsonObject lagCount=requestPayload.getAsJsonObject("response").getAsJsonArray("infoObjects").get(i).getAsJsonObject();

            for (Map.Entry<String, JsonElement> entry : lagCount.entrySet()){
                if (entry.getKey().equals("data")){
                    JsonObject dataObj = entry.getValue().getAsJsonObject();

                    // Handle attributes
                    if (dataObj.has("attributes")){
                        JsonObject attributesObj = dataObj.getAsJsonObject("attributes");
                        for (Map.Entry<String, JsonElement> attrbElem : attributesObj.entrySet()){
                            if (attrbElem.getValue().getAsJsonObject().has("group")){
                                count++;
                                continue;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
        }
    }

