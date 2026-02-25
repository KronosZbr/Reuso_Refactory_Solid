package br.com.nogueiranogueira.aularefatoracao.solidproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;

@Repository
public class GerenciadorUsuarioRepositoryImpl implements UsuarioCrudRepository {

    private final UsuarioRepository usuarioRepository;

    public GerenciadorUsuarioRepositoryImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public void excluir(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }
}