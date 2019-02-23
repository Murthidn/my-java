/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

package others;

import java.io.File;
import java.nio.file.Files;
import java.io.IOException;

class ReadResources{
    public static void main(String[]args) throws IOException{
        String fileName = "test.txt";
        ClassLoader classLoader = new ReadResources().getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        //Read File Content
        String content = new String(Files.readAllBytes(file.toPath()));
        System.out.println(content);
    }
}