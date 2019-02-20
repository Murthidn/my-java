/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

import java.util.Date;
import java.util.Scanner;
import java.io.FileWriter;
import java.text.SimpleDateFormat;

public class TimeFile{
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
        String lte = formatter.format(date);

        System.out.println("Enter path to save: \n" +
                "Example : /home/riversand/Documents/Feb20/EntityHistory/");
        String getPath = scanner.next();

        try{
            FileWriter fw = new FileWriter(getPath  + "EntityHistory_"+lte+".csv");
            fw.write("Hi");
            fw.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
        System.out.println("Success...");
    }
}








