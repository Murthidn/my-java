/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

import java.util.Date;
import java.util.List;
import javax.mail.Address;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Transport;
import java.util.Properties;
import com.google.gson.Gson;
import javax.mail.Authenticator;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import com.google.common.base.Strings;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import com.sun.mail.smtp.SMTPSendFailedException;

public class Mailer{
    MailConfig mailConfig;
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
    private static final String MAIL_SMTP_STARTTLS_ENABLE = "mail.smtp.starttls.enable";
    private static final String MAIL_SMTP_HOST = "mail.smtp.host";
    private static final String MAIL_SMTP_PORT = "mail.smtp.port";

    Mailer(String configPath){
        if(Strings.isNullOrEmpty(configPath)){
            return;
        }
        JsonObject mailConfigJson = FileHelper.readFileAsJson(configPath);
        this.mailConfig = new Gson().fromJson(mailConfigJson, MailConfig.class);
    }

    public boolean sendMail(String subject, String bodyText, List<String> attachmentPath){
        if (mailConfig == null){
            return false;
        }

        boolean mailResponseStatus = false;
        String bodyMsg = mailConfig.getDefaultMsg();
        if (!Strings.isNullOrEmpty(bodyText)){
            bodyMsg = bodyText;
        }
        try{
            if (mailConfig != null && mailConfig.isMailServiceEnabled()){
                final Properties emailProperties = buildEmailProperties(this.mailConfig);
                Session session = Session.getInstance(emailProperties, new Authenticator(){
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication(){
                        return new PasswordAuthentication(emailProperties.getProperty(EMAIL), emailProperties.getProperty(PASSWORD));
                    }
                  }
                );

                Message message = new MimeMessage(session);
                Address[] toList = new Address[mailConfig.getRecipients().size()];
                int i = 0;
                for (JsonElement to : mailConfig.getRecipients()){
                    toList[i] = new InternetAddress(to.getAsJsonPrimitive().getAsString());
                    i++;
                }
                message.setRecipients(Message.RecipientType.TO, toList);
                message.setFrom(new InternetAddress(emailProperties.getProperty(EMAIL)));
                if (!Strings.isNullOrEmpty(mailConfig.getSubject())){
                    message.setSubject(mailConfig.getSubject());
                }
                else{
                    message.setSubject(subject);
                }

                MimeBodyPart mbp1 = new MimeBodyPart();
                mbp1.setText(bodyMsg, "utf-8", "html");
                MimeMultipart mp = new MimeMultipart();
                mp.addBodyPart(mbp1);
                MimeBodyPart mbp2;

                // Attach specified files.
                if(attachmentPath != null){
                    for(String attachementFilePath:attachmentPath){
                        if (!Strings.isNullOrEmpty(attachementFilePath)){
                            mbp2 = new MimeBodyPart();
                            mbp2.attachFile(attachementFilePath);
                            mp.addBodyPart(mbp2);
                        }
                    }
                }

                message.setContent(mp,"text/html; charset=utf-8");

                message.setFrom(new InternetAddress(mailConfig.getEmailId()));
                message.setSentDate(new Date());
                Transport.send(message);
                System.out.println("Email Sent Successfully!");

                mailResponseStatus = true;
            }
        }
        catch (Exception ex){
            if (ex instanceof SendFailedException){
                MessagingException sfe = (MessagingException) ex;
                if (sfe instanceof SMTPSendFailedException){
                    System.out.println("SMTP SEND FAILED:");
                }
            }
            else{
                System.out.println("Got Exception: " + ex);
                ex.printStackTrace();
            }
        }
        finally{
            return mailResponseStatus;
        }
    }

    private Properties buildEmailProperties(MailConfig mailConfig){
        Properties emailProperties = null;
        if (mailConfig != null){
            emailProperties = new Properties();
            emailProperties.put(EMAIL, mailConfig.getEmailId());
            emailProperties.put(PASSWORD, mailConfig.getEmailPassword());
            emailProperties.put(MAIL_SMTP_AUTH, mailConfig.getMailSmtpAuth());
            emailProperties.put(MAIL_SMTP_STARTTLS_ENABLE, mailConfig.getMailSmtpStartTlsEnable());
            emailProperties.put(MAIL_SMTP_HOST, mailConfig.getMailSmtpHost());
            emailProperties.put(MAIL_SMTP_PORT, mailConfig.getMailSmtpPort());
        }
        return emailProperties;
    }

    // Provide filepath for mail config
    public MailConfig getMailConfig(){
        return mailConfig;
    }

    public void setMailConfig(MailConfig mailConfig){
        this.mailConfig = mailConfig;
    }

    static class MailConfig{
        private boolean isMailServiceEnabled = false;
        private String emailId = null;
        private String emailPassword = null;
        private String mailSmtpAuth = "false";
        private String mailSmtpPort = null;
        private String mailSmtpHost = null;
        private String mailSmtpStartTlsEnable = "false";
        private String subject = "Default subject";
        private String defaultMsg = "Default message";

        public boolean isMailServiceEnabled(){
            return isMailServiceEnabled;
        }

        public void setMailServiceEnabled(boolean mailServiceEnabled){
            isMailServiceEnabled = mailServiceEnabled;
        }

        public String getDefaultMsg() {
            return defaultMsg;
        }

        public void setDefaultMsg(String defaultMsg) {
            this.defaultMsg = defaultMsg;
        }

        public JsonArray getRecipients() {
            return recipients;
        }

        public void setRecipients(JsonArray recipients) {
            this.recipients = recipients;
        }

        JsonArray recipients = null;

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public JsonArray getToList() {
            return recipients;
        }

        public void setToList(JsonArray toList) {
            this.recipients = toList;
        }

        public String getEmailId() {

            return emailId;
        }

        public String getMailSmtpAuth() {
            return mailSmtpAuth;
        }

        public void setMailSmtpAuth(String mailSmtpAuth) {
            this.mailSmtpAuth = mailSmtpAuth;
        }

        public String getMailSmtpPort() {
            return mailSmtpPort;
        }

        public void setMailSmtpPort(String mailSmtpPort) {
            this.mailSmtpPort = mailSmtpPort;
        }

        public String getMailSmtpHost() {
            return mailSmtpHost;
        }

        public void setMailSmtpHost(String mailSmtpHost) {
            this.mailSmtpHost = mailSmtpHost;
        }

        public String getMailSmtpStartTlsEnable() {
            return mailSmtpStartTlsEnable;
        }

        public void setMailSmtpStartTlsEnable(String mailSmtpStartTlsEnable) {
            this.mailSmtpStartTlsEnable = mailSmtpStartTlsEnable;
        }

        public void setEmailId(String emailId) {
            this.emailId = emailId;
        }

        public String getEmailPassword() {
            return emailPassword;
        }

        public void setEmailPassword(String emailPassword) {
            this.emailPassword = emailPassword;
        }
    }
}
