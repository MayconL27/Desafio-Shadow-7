package com.consumer.microservice.controller;

import com.consumer.microservice.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("auth")
@RestController
public class TokenController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping(value = "/validatetoken")
    public boolean validarToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        String tkn = token.split(" ")[1];
        return usuarioService.validateToken(tkn);
    }

    public String getTypeUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        String tkn = token.split(" ")[1];
        return usuarioService.getTypeUser(tkn);
    }

}
