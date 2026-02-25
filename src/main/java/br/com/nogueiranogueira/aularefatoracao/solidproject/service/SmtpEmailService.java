package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

import org.springframework.stereotype.Service;

@Service
public class SmtpEmailService {

    public void sendEmail(String to, String subject, String body) {

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.office365.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); // Requisito obrigatório do Outlook


        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("teste", "senha");
            }
        });


        // Lógica para enviar email usando SMTP
        System.out.println("Enviando email para: " + to);
        System.out.println("Assunto: " + subject);
        System.out.println("Corpo: " + body);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("teste@teste.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("destinatario@gmail.com"));
            message.setSubject(subject);
            message.setText(body);

            System.out.println("Enviando...");
            Transport.send(message);
            System.out.println("E-mail enviado com sucesso!");

        } catch (MessagingException e) {

            e.printStackTrace();
        }
    }
}
