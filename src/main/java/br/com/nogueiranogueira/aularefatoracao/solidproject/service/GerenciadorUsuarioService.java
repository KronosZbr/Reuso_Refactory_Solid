package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

import br.com.nogueiranogueira.aularefatoracao.solidproject.dto.UsuarioDTO;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.repository.UsuarioRepository;
import br.com.nogueiranogueira.aularefatoracao.solidproject.service.regra.RegraUsuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class GerenciadorUsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final Map<String, RegraUsuario> regrasPorTipo;

    public GerenciadorUsuarioService(UsuarioRepository usuarioRepository,
                                     List<RegraUsuario> regras) {
        this.usuarioRepository = usuarioRepository;
        this.regrasPorTipo = regras.stream().collect(Collectors.toMap(
                RegraUsuario::tipoSuportado,
                Function.identity()
        ));
    }

    public Usuario criarUsuario(UsuarioDTO dto) {
        validarGerais(dto);

        if (usuarioRepository.existsByEmail(dto.email())) {
            // se quiser 409 depois, a gente ajusta no ExceptionHandler
            throw new IllegalArgumentException("E-mail já cadastrado");
        }

        RegraUsuario regra = regrasPorTipo.get(dto.tipo());
        if (regra == null) {
            throw new IllegalArgumentException("Tipo inválido");
        }

        // validações específicas do tipo
        regra.validar(dto);

        // cria entidade
        Usuario usuario = new Usuario(dto.nome(), dto.email(), dto.tipo());

        // aplica regra do tipo (pontos etc.)
        regra.aplicar(usuario, dto);

        return usuarioRepository.save(usuario);
    }

    private void validarGerais(UsuarioDTO dto) {
        if (dto.nome() == null || dto.nome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        if (dto.email() == null || !dto.email().contains("@")) {
            throw new IllegalArgumentException("E-mail inválido");
        }
    }
}