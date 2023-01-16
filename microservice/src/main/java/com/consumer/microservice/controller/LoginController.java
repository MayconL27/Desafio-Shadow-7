package com.consumer.microservice.controller;

import com.consumer.microservice.domain.Login;
import com.consumer.microservice.services.UsuarioService;
import com.consumer.microservice.services.dto.TokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping(value = "/login")
    public ResponseEntity<TokenDTO> login(@RequestBody Login login) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.loginUser(login));
    }

}
