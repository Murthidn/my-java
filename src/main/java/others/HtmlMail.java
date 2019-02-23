/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

package others;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class HtmlMail{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Mail world!");

        System.out.println("Enter JSON Mail Config File Path, ex: /home/murthidn/Documents/Names/Mail_Formats/GmailConfig.json");
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
            StringBuilder htmlBodyBuilder = new StringBuilder();
            htmlBodyBuilder.append("<html>");
            htmlBodyBuilder.append("<head><title>Mail World</title></head>");
            htmlBodyBuilder.append("<body><b>Heartily welcome to Riversand Technologies!</b></body>");
            htmlBodyBuilder.append("<br/>");
            htmlBodyBuilder.append("<br/>");
            htmlBodyBuilder.append("<br/>");
            htmlBodyBuilder.append("<b>Thanks and Regards,</b>");
            htmlBodyBuilder.append("<p>Development Team.</p>");
            htmlBodyBuilder.append("<p style=\"text-align: center;\"><span style=\"font-family: corbel,sans-serif; color: #999999; font-size: 8pt;\">Note:This is Auto Generated Mail!</span></p>");
            htmlBodyBuilder.append("<p style=\"text-align: center;\"><span style=\"font-family: corbel,sans-serif; color: #999999; font-size: 8pt;\">CopyRights 2018, Riversand Technologies</span></p>");
            htmlBodyBuilder.append("</body>");
            htmlBodyBuilder.append("</html>");
            mailer.sendMail(null, htmlBodyBuilder.toString(), null);
        }
    }
}

