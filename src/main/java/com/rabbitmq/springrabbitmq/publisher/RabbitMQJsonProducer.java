package com.rabbitmq.springrabbitmq.publisher;

import com.rabbitmq.springrabbitmq.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonProducer {

    private static final Logger LOG = LoggerFactory.getLogger(RabbitMQJsonProducer.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.json.routing.key")
    private String jsonRoutingKey;

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(User user){
        LOG.info(String.format("Json message sent -> %s",user.toString()));
        rabbitTemplate.convertAndSend(exchangeName,jsonRoutingKey,user);
    }
}
