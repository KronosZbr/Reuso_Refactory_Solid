package br.com.nogueiranogueira.aularefatoracao.solidproject.repository;

import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioCrudRepository {
    Usuario salvar(Usuario usuario);
    Optional<Usuario> buscarPorId(Long id);
    List<Usuario> buscarTodos();
    void excluir(Usuario usuario);
}