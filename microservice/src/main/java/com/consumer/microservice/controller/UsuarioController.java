package com.consumer.microservice.controller;

import com.consumer.microservice.client.UsuarioClient;
import com.consumer.microservice.domain.Usuario;
import com.consumer.microservice.services.dto.UsuarioDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RequestMapping("usuario")
@RestController
public class UsuarioController {

    @Autowired
    UsuarioClient usuarioClient;

    @GetMapping("/listartodos")
    public List<UsuarioDto> getAllUser() {
        return usuarioClient.getAllUser();
    }


}
