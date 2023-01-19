package com.consumer.microservice.client;

import com.consumer.microservice.domain.Login;
import com.consumer.microservice.domain.Usuario;
import com.consumer.microservice.services.dto.UsuarioDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "usuario", url = "http://localhost:8082") // porta da API usuario
public interface UsuarioClient {
    @GetMapping(value = "/usuario/listartodos") // listar todos os usuarios
    List<UsuarioDto> getAllUser();

<<<<<<<<< Temporary merge branch 1


    @PostMapping(value = "/login")
=========
    @PostMapping(value = "/usuario/login")
>>>>>>>>> Temporary merge branch 2
    Usuario loginUsuario(@RequestBody Login loginDTO);


}
