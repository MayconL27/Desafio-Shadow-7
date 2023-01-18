package com.consumer.microservice.controller;

import com.consumer.microservice.client.UsuarioClient;
import com.consumer.microservice.services.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("usuario")
@RestController
public class UsuarioControllerFeign {
    @Autowired
    UsuarioClient usuarioClient;
    @GetMapping
    public List<UsuarioDto> getUsuario() {
        return usuarioClient.getAllUser();
    }
}
