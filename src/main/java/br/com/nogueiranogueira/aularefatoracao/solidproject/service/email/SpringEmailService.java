package br.com.nogueiranogueira.aularefatoracao.solidproject.service.email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SpringEmailService implements EmailService {

    private final JavaMailSender mailSender;

    public SpringEmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void enviar(String para, String assunto, String mensagem) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(para);
        msg.setSubject(assunto);
        msg.setText(mensagem);
        mailSender.send(msg);
    }
}