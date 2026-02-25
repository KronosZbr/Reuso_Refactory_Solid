package br.com.nogueiranogueira.aularefatoracao.solidproject.service.regra;

import br.com.nogueiranogueira.aularefatoracao.solidproject.dto.UsuarioDTO;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;

public interface RegraUsuario {
    String tipoSuportado();              // ex: "VIP", "COMUM"
    void validar(UsuarioDTO dto);
    void aplicar(Usuario usuario, UsuarioDTO dto);
}