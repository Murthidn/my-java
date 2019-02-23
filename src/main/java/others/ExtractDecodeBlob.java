/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

package others;

import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.codec.binary.Base64;

public class ExtractDecodeBlob{
    public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("Base64 Decode!");
        System.out.println();
        System.out.println("Enter blob JSON files path: \n"
                + "example :  /home/murthidn/a.json");
        String fielPath = "/home/murthidn/a.json";
        System.out.println();

        System.out.println("Enter output path: \n"
                + "example : /home/murthidn/output/");
        String outputFile = "/home/murthidn/output/";

        JsonObject originalJsonFile = new JsonObject();
        JsonParser parser = new JsonParser();
        JsonObject firstBlobPoint;
        String firstBlob;
        String decryptedFirstBlobString;
        JsonObject decryptedFirstBlob;
        JsonObject secondBlobPoint;
        String secondBlob;
        String decryptedSecondBlobString;
        JsonObject decryptedSecondBlob;
        String fileId;
        String fileIdName;
        String prepareFile;
        int count = 0;

        try{
            originalJsonFile = FileHelper.readFileAsJson(fielPath);
        }
        catch (Exception e){
            System.out.println("[STATUS]:[ERROR]");
            System.out.println("JSON Format Error for ");
        }

        //Decrypting 1st Blob Part
        JsonArray totalBlobs = originalJsonFile.getAsJsonObject("response").getAsJsonArray("binaryObjects");

        for (int i = 0; i < totalBlobs.size(); i++){
            firstBlobPoint = originalJsonFile.getAsJsonObject("response").getAsJsonArray("binaryObjects").get(i).getAsJsonObject().getAsJsonObject("data");
            firstBlob = firstBlobPoint.get("blob").getAsString();

            decryptedFirstBlobString = new String(Base64.decodeBase64(firstBlob.getBytes()));
            decryptedFirstBlob = (JsonObject) parser.parse(decryptedFirstBlobString);

            //Decrypting 2nd Blob Part
            secondBlobPoint = decryptedFirstBlob.getAsJsonObject("dataObject").getAsJsonObject("data");
            secondBlob = secondBlobPoint.get("blob").getAsString();

            decryptedSecondBlobString = new String(Base64.decodeBase64(secondBlob.getBytes()));
            decryptedSecondBlob = (JsonObject) parser.parse(decryptedSecondBlobString);

            //Writing Output
            count++;
            fileId = originalJsonFile.getAsJsonObject("response").getAsJsonArray("binaryObjects").get(i).getAsJsonObject().get("id").toString();

            //get("id").toString();
            fileIdName = fileId.replace("\"", "");
            prepareFile = outputFile + fileIdName + ".json";
            File file = new File(prepareFile);

            if (file.createNewFile()){
                System.out.println();
                System.out.println("File: " + count + " [STATUS]:[CREATED] ");
                System.out.println();
                System.out.println("Blob JSON file decoded, saved in  " + prepareFile);
            }
            else{
                System.out.println();
                System.out.println("File: " + count + " [STATUS]:[UPDATED] ");
                System.out.println();
                System.out.println("This file \"" + fileIdName + ".json\" already exists in  " + outputFile);
                System.out.println();
                System.out.println("Blob JSON file decoded, saved in  " + prepareFile);
            }

            try{
                FileWriter fw = new FileWriter(prepareFile);
                fw.write(String.valueOf(decryptedSecondBlob));
                fw.close();
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }
}


