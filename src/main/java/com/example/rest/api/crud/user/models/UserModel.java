package com.example.rest.api.crud.user.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity //definir a classe como entidade do banco de dados
@Data// criar gets e sets(encapsulamento)
@Table(name = "t_users")// referencia a tabela no banco
@AllArgsConstructor // criar um contrutor privado com argumentos
@NoArgsConstructor// criar um contrutor privado sem argumentos
public class UserModel { //

    @Id//definir chave primaria
    @GeneratedValue(strategy = GenerationType.AUTO)//gerar um id automatico a cada inserção no banco
    Long id;
    String username;
    String password;
    String email;
    //valores criados criados no banco
}

