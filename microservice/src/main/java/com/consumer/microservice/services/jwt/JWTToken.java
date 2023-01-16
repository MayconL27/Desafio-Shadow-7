package com.consumer.microservice.services.jwt;

import com.consumer.microservice.domain.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTToken {
    // private static final long expirationTime = 1800000; // 30 min
    private final String secret = "A+X;fTJP&Pd,TD9dwVq(hsHX,ya^<wsD_UK7L+@=S;{'CydP]{v@}G'b>et;yz$*\\\\yL5S8EJN:%P:X%H9>#nYLrX}@\\\\s?CQcpspH,2emzBc!Q[V'AYa~uzF8WR~AUrMzxp/V$9([S9X#zj/CH('#]B_Hc+%fGhe27YB;^j4\\\\Xk=Ju\\\"Ap~_&<L;=!Z;!,2UP;!hF3P]j85#*`&T]/kB/W^6$v~u6qpejL>kY^f)sy4:qTq_Ec!-z!@aAp~sLKGU>$";

    public String generateToken(Usuario userDto) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("email" , userDto.getEmail());
        claims.put("name", userDto.getNome());
        claims.put("tipoUsuario", userDto.getTipoUsuario());
        claims.put("cpf", userDto.getCpf());

        return Jwts.builder().setIssuer("localhost:8081")
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration((new Date(new Date().getTime() + Long.parseLong("1800000"))))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }
    public boolean tokenValid(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    public String tipoUsuario(String token) {
        try {
            Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
            return body.values().stream().toArray()[0].toString();
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }




}
