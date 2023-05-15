package com.rabbitmq.springrabbitmq.consumer;

import com.rabbitmq.springrabbitmq.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);

    @RabbitListener(queues = "${rabbitmq.json.queue.name}")
    public void jsonConsumer(User user){
        LOG.info(String.format("Json Message received -> %s",user.toString()));
    }
}
