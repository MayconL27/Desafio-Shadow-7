package com.consumer.microservice.client;

import com.consumer.microservice.domain.Login;
import com.consumer.microservice.domain.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "feign", url = "http://localhost:8082/usuario") // porta da API usuario
public interface UsuarioClient {
    @GetMapping(value = "/listartodos")
    Usuario loginUsuario(@RequestBody Login loginDTO);

}
