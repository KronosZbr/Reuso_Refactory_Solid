package br.com.nogueiranogueira.aularefatoracao.solidproject.service.regra;

import br.com.nogueiranogueira.aularefatoracao.solidproject.dto.UsuarioDTO;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class RegraUsuarioComum implements RegraUsuario {

    @Override
    public String tipoSuportado() {
        return "COMUM";
    }

    @Override
    public void validar(UsuarioDTO dto) {
        // regra comum: nenhuma extra além das validações gerais
    }

    @Override
    public void aplicar(Usuario usuario, UsuarioDTO dto) {
        usuario.setPontos(0);
    }
}