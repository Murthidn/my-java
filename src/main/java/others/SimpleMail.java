/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

package others;

import javax.mail.Session;
import java.io.FileReader;
import javax.mail.Message;
import java.io.IOException;
import javax.mail.Transport;
import java.util.Properties;
import javax.mail.Authenticator;
import org.json.simple.JSONObject;
import javax.mail.internet.MimeMessage;
import org.json.simple.parser.JSONParser;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import org.json.simple.parser.ParseException;

public class SimpleMail{
    private static final String RECIPIENTS_EMAIL = "murthy.nagaraju@riversand.com";
    private static final String RECIPIENTS_EMAIL2 = "dream.fan.india@gmail.com";

    public static void main(String[]args) throws IOException, ParseException{
        Properties mailProps = new Properties();
        mailProps.put("mail.smtp.host", "smtp.gmail.com");
        mailProps.put("mail.smtp.port", "587");
        mailProps.put("mail.smtp.auth", "true");
        mailProps.put("mail.smtp.starttls.enable", "true");

        Authenticator authenticator = new Authenticator(){
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("/home/riversand/Videos/Data/Java Projects/java-mail-sender/target/cred/loc.json"));
            JSONObject jsonObject = (JSONObject) obj;
            String user = (String) jsonObject.get("user");
            String pw = (String) jsonObject.get("pw");
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(user, pw);
            }
        };

        Session session = Session.getDefaultInstance(mailProps, authenticator);
        try{
            final MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress());
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(RECIPIENTS_EMAIL));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(RECIPIENTS_EMAIL2));

            message.setSubject("Hello!");
            message.setText("This email was sent using JavaMail API through Gmail! Isn't it awesome?");
            System.out.println("Sending email...");
            Transport.send(message);
            System.out.println("Email sent!");
        }
        catch(Exception e){
            System.err.println("Problem sending email. Exception : " + e.getMessage());
        }
    }
}