/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

package others;

import java.io.FileWriter;

public class FileCreation{
    public static void main(String args[]){
        try{
            FileWriter fw=new FileWriter("C:\\Users\\dnmurthi\\Desktop\\test2.txt");
            fw.write("Welcome to javaTpoint.");
            fw.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        System.out.println("Success...");
    }
}