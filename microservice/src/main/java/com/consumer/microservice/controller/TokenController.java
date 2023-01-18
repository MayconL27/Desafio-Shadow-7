package com.consumer.microservice.controller;

import com.consumer.microservice.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpHeaders;

@RequestMapping("auth")
@RestController
public class TokenController {
    @Autowired
    UsuarioService usuarioService;


}
