/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

package others;

import java.io.File;

public class LoopFile{
    public static void main(String[]args){

        String dirPath = "/home/murthidn/Documents/test/";
        File dir = new File(dirPath);
        String[] files = dir.list();

        if (files.length == 0){
            System.out.println("The directory is empty");
        }
        else{
            for (String aFile : files){
                System.out.println(aFile);
            }
        }
    }
}


