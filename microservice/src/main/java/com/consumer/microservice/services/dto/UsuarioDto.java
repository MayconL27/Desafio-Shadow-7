package com.consumer.microservice.services.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UsuarioDto {

    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private TipoUsuario tipoUsuario;

}
