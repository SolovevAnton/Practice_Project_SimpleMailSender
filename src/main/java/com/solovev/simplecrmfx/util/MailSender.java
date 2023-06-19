package com.solovev.simplecrmfx.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


/**
 * class to send mail, with mail.ru account
 */
public class MailSender {
    private final String from;
    private final String password;
    private final String to;

    /**
     * @param from mail.ru account
     * @param password pass for external apps
     * @param to mail where to send the letter
     */
    public MailSender(String from, String password, String to) {
        this.from = from;
        this.password = password;
        this.to = to;
    }

    /**
     * Method to define mail
     * @param subject of the mail
     * @param text of the mail
     * @return true if send successfully, error otherwise
     */

    public boolean send(String subject, String text) {
        String host = "smtp.mail.ru";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtps.ssl.checkserveridentity", true);
        props.put("mail.smtps.ssl.trust", "*");
        props.put("mail.smtp.ssl.enable", "true");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator(){
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(this.from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(this.to));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);
            return true;
        }catch (MessagingException e){
            e.printStackTrace();
            throw new IllegalArgumentException("Error sending message!");
        }
    }
}
