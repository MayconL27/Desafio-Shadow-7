package com.consumer.microservice.services.jwt;

import com.consumer.microservice.domain.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTToken {

    private final String secret = "oi";

    public String genrateToken(Usuario userDto) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", userDto.getEmail());
        claims.put("name", userDto.getName());
        claims.put("cpf", userDto.getCpf());
        claims.put("cpf", userDto.getTipoUsuario());

        return Jwts.builder().setIssuer("localhost:8081")
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + Long.parseLong("60000")))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }



}
