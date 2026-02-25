package br.com.nogueiranogueira.aularefatoracao.solidproject.service.email;

public interface EmailService {
    void enviar(String para, String assunto, String mensagem);
}