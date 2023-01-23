package com.consumer.microservice.client;

import com.consumer.microservice.domain.Login;
import com.consumer.microservice.domain.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@FeignClient(name = "usuario", url = "http://localhost:8082") // porta da API usuario
public interface UsuarioClient {

    @PostMapping(value = "/usuario/login")
    Usuario loginUsuario(@RequestBody Login loginDTO);

}
