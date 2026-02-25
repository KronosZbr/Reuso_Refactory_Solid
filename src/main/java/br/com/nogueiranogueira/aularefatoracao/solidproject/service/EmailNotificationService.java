package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

import br.com.nogueiranogueira.aularefatoracao.solidproject.service.email.EmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements NotificationService {

    private final EmailService emailService;

    public EmailNotificationService(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void enviarBoasVindas(String email, String nome) {
        emailService.enviar(
                email,
                "Bem-vindo!",
                "Olá " + nome + ", seu cadastro foi realizado com sucesso."
        );
    }
}