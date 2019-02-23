/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

package others;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class SendMail{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Mail world!");

        System.out.println("Enter JSON Mail Config File Path, ex: /home/murthidn/Documents/mailConfig.json");
        String mailConfig = sc.next();

        System.out.println("Do you have Attachment to send?\n" +
                "yes/no");
        Boolean isAttachment = sc.next().equalsIgnoreCase("yes") ? true : false;

        String mailAttach = new String();
        if (isAttachment){
            System.out.println("Provide attachment fileName, please make sure Google file size limit is 25 MB.");
            mailAttach = sc.next();
        }
        System.out.println("Wait, sending...");

        Mailer mailer = new Mailer(mailConfig);

        if (isAttachment){
            String body = "Heartily welcome to Riversand Technologies! Please find mail attachment bellow...";

            List<String> fileList = new ArrayList<>();
            fileList.add(mailAttach);

            mailer.sendMail(null, body, fileList);
        }
        else{
            String body = "Heartily welcome to Riversand Technologies!";
            mailer.sendMail(null, body, null);
        }
    }
}

