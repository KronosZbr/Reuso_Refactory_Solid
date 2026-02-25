package br.com.nogueiranogueira.aularefatoracao.solidproject.service.regra;

import br.com.nogueiranogueira.aularefatoracao.solidproject.dto.UsuarioDTO;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class RegraUsuarioVip implements RegraUsuario {

    @Override
    public String tipoSuportado() {
        return "VIP";
    }

    @Override
    public void validar(UsuarioDTO dto) {
        if (dto.idade() < 18) {
            throw new IllegalArgumentException("Usuário deve ser maior de idade");
        }
    }

    @Override
    public void aplicar(Usuario usuario, UsuarioDTO dto) {
        usuario.setPontos(100);
    }
}