package com.fr.mailsenderrabbitmq.service;

import com.fr.mailsenderrabbitmq.entity.Utilisateur;
import org.example.UtilisateurRabbitMQ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqConsumer {

    private Logger LOGGER = LoggerFactory.getLogger(RabbitMqConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(String message) {
        LOGGER.info(String.format("Message reçu ! -> %s", message));
    }

    @RabbitListener(queues = {"${rabbitmq.json.queue.name}"})
    public void consumeJson(UtilisateurRabbitMQ utilisateur) {
        LOGGER.info(String.format("Utilisateur reçu ! %s", utilisateur.toString()));
    }

}
