package com.example.rest.api.crud.user.controllers;

import com.example.rest.api.crud.user.repositories.UserRepository;
import com.example.rest.api.crud.user.models.UserModel;
import com.example.rest.api.crud.user.publish.QueueSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//basicamente vai controlar o CRUD nessa classe, especiealmente para adicionar os email a fila


@RestController//retornar o objeto e os dados do objeto para gravar em uma resposta json e efetuar o cadastros
public class UserController {

    UserRepository repository;//

    QueueSender queueSender;//

    @Autowired//criar o csontrutor automaticamente na classe injetando os paramestros
    public UserController(UserRepository repository, QueueSender queueSender) {
        this.repository = repository;
        this.queueSender = queueSender;
    }

    @GetMapping("/user")//retornar todos os usuarios
    public List<UserModel> getAllUsers(){
        return repository.findAll();
    }

    @GetMapping("/user/{id}")//retorna usuario pelo id
    public UserModel getUserById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping("/usersave")//salva o usuario
    public UserModel saveUser(@RequestBody UserModel userModel) {
        queueSender.send(userModel.getEmail());//chama o email que é inserido no insomnia e manda pra fila
        return repository.save(userModel);//salva o user model
    }

    @DeleteMapping("/user/{id}")//deletar ususario pelo ID
    public void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }

    //@PathVariable vincular o id dos mappings para o id dos usuarios
    //@RequestBody Usuario é buscado no corpo da requisição
}
