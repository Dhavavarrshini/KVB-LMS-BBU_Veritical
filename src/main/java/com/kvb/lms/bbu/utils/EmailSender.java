package com.kvb.lms.bbu.utils;

import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.*;
import java.nio.file.*;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class EmailSender {

    public static void sendReport(String toEmail, String reportFolderPath) {
        final String fromEmail = "dhavavarrshini@gmail.com"; // your Gmail
        final String password = "kvpq uinm sciu zngs"; // App Password (not Gmail login)

        // SMTP setup
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            // 1️⃣ Zip the cucumber-reports folder
            String zipFilePath = reportFolderPath + ".zip";
            zipFolder(Paths.get(reportFolderPath), Paths.get(zipFilePath));

            // 2️⃣ Create Email
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(fromEmail));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            msg.setSubject("Automation Test Report");

            // Body
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Hi Team,\n\nPlease find the attached automation test report.\n\nRegards,\ndhava");

            // Attachment (zip file)
            MimeBodyPart attachmentPart = new MimeBodyPart();
            DataSource source = new FileDataSource(zipFilePath);
            attachmentPart.setDataHandler(new DataHandler(source));
            attachmentPart.setFileName("AutomationReport.zip");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);

            msg.setContent(multipart);

            // 3️⃣ Send email
            Transport.send(msg);
            System.out.println("Report emailed successfully with ZIP attachment!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Helper method to zip folder
    private static void zipFolder(Path sourceFolder, Path zipFilePath) throws IOException {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFilePath.toFile()))) {
            Files.walk(sourceFolder).filter(path -> !Files.isDirectory(path)).forEach(path -> {
                ZipEntry zipEntry = new ZipEntry(sourceFolder.relativize(path).toString());
                try {
                    zos.putNextEntry(zipEntry);
                    Files.copy(path, zos);
                    zos.closeEntry();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
