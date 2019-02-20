/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

import java.io.File;

public class SuperMail{
   public static void main(String[]args){
      String readFile = "mailConfig.json";

      ClassLoader classLoader = new ReadResources().getClass().getClassLoader();
      File mailfile = new File(classLoader.getResource(readFile).getFile());

      String mailConfig = new String(mailfile.toString());

      Mailer mailer = new Mailer(mailConfig);

      String body = "2:Heartily welcome to Riversand Technologies!";

      mailer.sendMail("hi", body, null);
   }
}
