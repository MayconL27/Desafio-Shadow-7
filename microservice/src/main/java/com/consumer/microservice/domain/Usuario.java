package com.consumer.microservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario {

    private String email;
    private String name;
    private String cpf;
    private String tipoUsuario;
}
