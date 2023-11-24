package com.fr.mailsenderrabbitmq.service;

import org.example.UtilisateurRabbitMQ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqConsumer {

    private Logger LOGGER = LoggerFactory.getLogger(RabbitMqConsumer.class);
    private MailSenderService mailSenderService;

    public RabbitMqConsumer(MailSenderService mailSenderService) {
        this.mailSenderService = mailSenderService;
    }

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(String message) {
        LOGGER.info(String.format("Message reçu ! -> %s", message));
    }

    @RabbitListener(queues = {"${rabbitmq.json.queue.name}"})
    public void consumeJson(UtilisateurRabbitMQ utilisateur) {
        LOGGER.info(String.format("Utilisateur reçu ! %s", utilisateur.toString()));
        this.mailSenderService.sendEmail(
                utilisateur.getMail(),
                "Mail de confirmation",
                "Merci de vérifier votre email afin de valider l'inscription");

    }

}
