package com.consumer.microservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario {

    private String nome;
    private String cpf;
    private String email;
    private String tipoUsuario;

}
