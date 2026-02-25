package br.com.nogueiranogueira.aularefatoracao.solidproject.controller;

import br.com.nogueiranogueira.aularefatoracao.solidproject.dto.UsuarioDTO;
import br.com.nogueiranogueira.aularefatoracao.solidproject.service.GerenciadorUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gerenciador/usuarios")
public class GerenciadorUsuarioController {
    @Autowired
    private GerenciadorUsuarioService gerenciadorUsuarioService;

    @PostMapping()
    public ResponseEntity<String> criarUsuario(@RequestBody UsuarioDTO usuario) {
        try {
            gerenciadorUsuarioService.criarUsuario(usuario);
            return ResponseEntity.ok("Usuário criado com sucesso");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao criar usuário");
        }
    }
}
