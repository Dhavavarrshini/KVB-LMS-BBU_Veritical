package com.kvb.lms.bbu.utils;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class EmailSender {

    public static void sendReport(String toEmail, String reportFilePath) {
        // Gmail SMTP settings
        final String fromEmail = "dhavavarrshini@gmail.com"; // replace with your Gmail
        final String appPassword = "kvpq uinm sciu zngs"; // replace with your Gmail App Password

        // Check if file exists
        File reportFile = new File(reportFilePath);
        if (!reportFile.exists()) {
            throw new RuntimeException("Report file not found: " + reportFilePath);
        }

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Session with authentication
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, appPassword);
            }
        });

        try {
            // Create email
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toEmail)
            );
            message.setSubject("Automation Test Report");

            // Plain text intro
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText("Hi Team,\n\nPlease find the Automation Test Report below and attached.\n\nRegards,\nAutomation Bot");

            // Embed HTML in email body
            MimeBodyPart htmlPart = new MimeBodyPart();
            String htmlContent = new String(java.nio.file.Files.readAllBytes(reportFile.toPath()), java.nio.charset.StandardCharsets.UTF_8);
            htmlPart.setContent(htmlContent, "text/html; charset=utf-8");

            // Attach HTML as file too
            MimeBodyPart attachmentPart = new MimeBodyPart();
            DataSource source = new FileDataSource(reportFile);
            attachmentPart.setDataHandler(new DataHandler(source));
            attachmentPart.setFileName("AutomationReport.html");

            // Combine all
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(htmlPart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);


            // Send email
            Transport.send(message);
            System.out.println("✅ Report emailed successfully to " + toEmail);

        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to send email: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
