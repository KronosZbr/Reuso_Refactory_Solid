package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

//import br.com.nogueiranogueira.aularefatoracao.solidproject.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioMailSenderService {

    @Autowired
    //private UsuarioRepository usuarioRepository;

    private SmtpEmailService smtpEmailService;

    public UsuarioMailSenderService() {
        this.smtpEmailService = new SmtpEmailService();
    }

    public void enviarEmailBoasVindas(String email) {
        // Lógica para enviar email de boas-vindas
        String assunto = "Bem-vindo ao nosso sistema!";
        String mensagem = "Olá! Obrigado por se cadastrar em nosso sistema.";
        smtpEmailService.sendEmail(email, assunto, mensagem);
    }


}
