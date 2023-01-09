package com.shadow.autenticacao.controller;

import com.shadow.autenticacao.model.UsuarioModel;
import com.shadow.autenticacao.repository.UsuarioRepository;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Data
@RestController
@RequestMapping("/api")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder encoder;
    @GetMapping("/list")
    public ResponseEntity<List<UsuarioModel>> listarUser() {
        return ResponseEntity.ok(usuarioRepository.findAll());
    }
    @PostMapping("/salvar")
    public ResponseEntity<UsuarioModel> salvar(@RequestBody UsuarioModel usuarioModel) {
        usuarioModel.setPassword(encoder.encode(usuarioModel.getPassword()));
        return ResponseEntity.ok(usuarioRepository.save(usuarioModel));
    }
    @GetMapping("/validarPassword")
    public ResponseEntity<Boolean> validarPassword(@RequestParam String login, @RequestParam String password) {
        Optional<UsuarioModel> optUsuario = usuarioRepository.findByLogin(login);
        if (optUsuario.isEmpty()) { // Se o usuário não for encontrado.
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }
        boolean valid = encoder.matches(password, optUsuario.get().getPassword());
        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);
    }
}
