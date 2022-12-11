package com.example.rest.api.crud.user.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

//padrão do springboot para facilitar o processamento com o banco de dados e comunicação client servidor
//Data transfer Object
public class UserDto {

    @NotBlank//para não virem nulos os valores
    String username;
    @NotBlank//para não virem nulos os valores
    String password;
    @Email//referenciar o email que vai ser cadastrado
    String email;
}
