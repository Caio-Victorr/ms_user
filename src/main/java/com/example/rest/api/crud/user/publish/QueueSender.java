package com.example.rest.api.crud.user.publish;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Mandar os emails para a fila

@Component//detecta os beans customizados automaticamente
public class QueueSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;//bean padrão do Rabbit

    @Autowired
    private Queue queue;//chamou o metodo queue(bean)

    public void send(String email) {
        rabbitTemplate.convertAndSend(this.queue.getName(), email); //converte o email e envia para a fila de acordo com o nome da fila(nativo do rabbit)
    }
}
