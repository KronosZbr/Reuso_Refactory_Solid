package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescontoService {
    public int calculaDescontoTotal(List<Usuario> usuarios) {
        return usuarios.stream()
                .mapToInt(Usuario::getDesconto)
                .sum();
    }
}
