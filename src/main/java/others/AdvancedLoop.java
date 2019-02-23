/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

package others;

import java.util.Scanner;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;

public class AdvancedLoop {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter JSON file");
        String data = sc.next();

        JsonObject getQueryRequest= FileHelper.readFileAsJson(data);

        if (getQueryRequest.has("params")
                && getQueryRequest.get("params").getAsJsonObject().has("fields")){
            JsonObject fieldsObj = getQueryRequest.get("params").getAsJsonObject().getAsJsonObject("fields");

            if (fieldsObj.has("attributes")){
                JsonArray attributesArray = fieldsObj.getAsJsonArray("attributes");
                for (JsonElement attrbElem : attributesArray){
                    System.out.println(attrbElem.getAsString());
                }
            }
        }
    }
}


