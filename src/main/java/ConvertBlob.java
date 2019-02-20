/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;
import org.apache.commons.codec.binary.Base64;

public class ConvertBlob{
    public static void main(String[]args){
         try{
            Scanner sc = new Scanner(System.in);

            System.out.println();
            System.out.println("Base64 Decode!");
            System.out.println();
            System.out.println("Enter blob JSON files' folder path: \n"
                    + "example :  /home/murthidn/Documents/test/");
            String dirPath = sc.next();
            System.out.println();

            System.out.println("Enter output path: \n"
                    + "example : /home/murthidn/Documents/test/");
            String outputFile = sc.next();

            JsonObject originalJsonFile;
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
            int count=0;

            File dir = new File(dirPath);
            String[] files = dir.list();

            System.out.println("Total no. of files: "+files.length);

            if (files.length == 0){
                System.out.println("This directory is empty!");
            }
            else{
                for (String aFile : files){
                    try{
                        originalJsonFile = FileHelper.readFileAsJson(dirPath + aFile);
                    }

                    catch (Exception e){
                        System.out.println();
                        System.out.println("[STATUS]:[ERROR]");
                        System.out.println("JSON Format Error for "+ aFile);
                        continue;
                    }

                    //Decrypting 1st Blob Part
                    firstBlobPoint = originalJsonFile.getAsJsonObject("data");
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
                    fileId = originalJsonFile.get("id").toString();
                    fileIdName = fileId.replace("\"", "");

                    prepareFile = outputFile + fileIdName + ".json";

                    File file = new File(prepareFile);

                    if (file.createNewFile()){
                        System.out.println();
                        System.out.println("File: "+count+" [STATUS]:[CREATED] ");
                        System.out.println();
                        System.out.println("Blob JSON file decoded, saved in  " + prepareFile);
                    }
                    else{
                        System.out.println();
                        System.out.println("File: "+count+" [STATUS]:[UPDATED] ");
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
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
