package com.consumer.microservice.services;

import com.consumer.microservice.client.UsuarioClient;
import com.consumer.microservice.domain.Login;
import com.consumer.microservice.domain.Usuario;
import com.consumer.microservice.services.dto.TokenDTO;
import com.consumer.microservice.services.jwt.JWTToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    JWTToken jwtToken;
    @Autowired
    UsuarioClient usuarioClient;

    public TokenDTO loginUser(Login loginDto) {
        Usuario usuario = usuarioClient.loginUsuario(loginDto);
        if (usuario == null) {
            throw new RuntimeException("Usuário inválido");
        }
        String token = jwtToken.generateToken(usuario);

        return TokenDTO.builder().type("Bearer").token(token).build();
    }

    public boolean validateToken(String token) {
        return jwtToken.tokenValid(token);
    }

    public String getTypeUser(String token) {
        return jwtToken.tipoUsuario(token);
    }


}
