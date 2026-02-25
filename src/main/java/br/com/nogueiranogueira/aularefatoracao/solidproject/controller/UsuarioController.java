package br.com.nogueiranogueira.aularefatoracao.solidproject.controller;

import br.com.nogueiranogueira.aularefatoracao.solidproject.dto.UsuarioDTO;
import br.com.nogueiranogueira.aularefatoracao.solidproject.service.GerenciadorUsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final GerenciadorUsuarioService gerenciadorUsuarioService;

    public UsuarioController(GerenciadorUsuarioService gerenciadorUsuarioService) {
        this.gerenciadorUsuarioService = gerenciadorUsuarioService;
    }

    @PostMapping
    public ResponseEntity<String> criarUsuario(@Validated @RequestBody UsuarioDTO usuario) {
        gerenciadorUsuarioService.criarUsuario(usuario);
        return ResponseEntity.ok("Usuário criado com sucesso");
    }
}