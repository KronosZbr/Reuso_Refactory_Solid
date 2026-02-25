package br.com.nogueiranogueira.aularefatoracao.solidproject.dto;

public record UsuarioDTO(
        Long id,
        String nome,
        String email,
        String tipo,
        int idade
) {
}
