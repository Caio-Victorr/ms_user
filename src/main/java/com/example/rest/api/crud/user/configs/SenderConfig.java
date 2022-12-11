package com.example.rest.api.crud.user.configs;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//cria uma classe que nela vai ta composta as beans da aplicação
public class SenderConfig {
    @Value("${spring.queue.name}")//captura o valor em uma variavel que carrega o nome da fila
    private String userqueue;

    @Bean//Anotação do spring ele pega os metodos para outras classes que possa injetar suas depencias na classe
    public Queue queue() {
        return new Queue(userqueue, true);
    }//passa o nome da fila e mantenha duravel a fila
}
