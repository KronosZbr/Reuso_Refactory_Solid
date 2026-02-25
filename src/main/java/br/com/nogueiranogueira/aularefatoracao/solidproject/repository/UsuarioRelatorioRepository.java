package br.com.nogueiranogueira.aularefatoracao.solidproject.repository;

import java.util.List;

public interface UsuarioRelatorioRepository {
    long contarUsuariosPorTipo(String tipoUsuario);
    List<Object[]> gerarRelatorioUsuariosPorTipo();
}