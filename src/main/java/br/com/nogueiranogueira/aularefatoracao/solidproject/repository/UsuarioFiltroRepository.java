package br.com.nogueiranogueira.aularefatoracao.solidproject.repository;

import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;

import java.util.List;

public interface UsuarioFiltroRepository {
    List<Usuario> buscarPorFiltrosAvancados(String nome, String email, String tipoUsuario);
}