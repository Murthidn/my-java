/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

package others;

import java.util.Date;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class CreateCsv{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 'Yes' to create File Name Automatically in Given Path! \n"
                + "Enter 'No'  to give Your own New File Path...");

        Boolean checkFileName = sc.next().equalsIgnoreCase("yes") ? true : false;
        String autoFile = "";

        if (checkFileName){
            System.out.println();
            System.out.println("Enter only Folder Path \n"
                    + "example: /home/riversand/Documents/March9/folder/");
            String folderPath = sc.next();

            Date date = new Date();

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
            String newFile = formatter.format(date);
            autoFile = folderPath+"MyCsv="+newFile+".csv";
        }
        else{
            System.out.println();
            System.out.println("Enter New File Path \n"
                    +"example: /home/riversand/Documents/March9/folder/MyCSV");
            String prepareFile = sc.next();

            autoFile=prepareFile+".csv";
        }
        generateCsvFile(autoFile);
    }

    public static void generateCsvFile(String filename){
        FileWriter writer = null;
        try{
            writer = new FileWriter(filename);

            writer.append("Name");
            writer.append(',');
            writer.append("Number");
            writer.append('\n');

            writer.append("Interview Questions");
            writer.append(',');
            writer.append("001");
            writer.append('\n');

            writer.append("Interview Programs");
            writer.append(',');
            writer.append("002");
            writer.append('\n');

            System.out.println();
            System.out.println("[STATUS]: [SUCCESS]");
            System.out.println();
            System.out.println("New CSV File is Created in = "+filename);
        }

        catch (IOException e){
            e.printStackTrace();
        }

        finally{
             try{
                writer.flush();
                writer.close();
             }
             catch (IOException e){
                e.printStackTrace();
             }
        }
    }
}


