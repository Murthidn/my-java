/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

import java.util.Date;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class SmartDate{
    public static void main(String[]args) throws IOException{
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Folder Path: \n"
                +"ex: /home/murthidn/Documents/");
        String folderPath=sc.next();

        String fileName ="FileFrom_"+new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss'.xlsx'").format(new Date());
        String filePath=folderPath+fileName;
        FileWriter fw=new FileWriter(filePath);

        try{
            fw.write("Welcome to Bengaluru!");
            fw.write("\n");
            fw.write("Enjoy the Silicon Valley!");
            fw.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Successfully created file in "+filePath);
    }
}
