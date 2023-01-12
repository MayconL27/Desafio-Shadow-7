package com.consumer.feign.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PostDTO {

     private String nome;
     private String cpf;
     private String email;
     private String user;
     private String senha;
     private String tipoUsuario;

}
