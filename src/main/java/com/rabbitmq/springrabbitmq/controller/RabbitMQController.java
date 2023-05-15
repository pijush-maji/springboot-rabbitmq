package com.rabbitmq.springrabbitmq.controller;

import com.rabbitmq.springrabbitmq.dto.User;
import com.rabbitmq.springrabbitmq.publisher.RabbitMQJsonProducer;
import com.rabbitmq.springrabbitmq.publisher.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class RabbitMQController {

    private RabbitMQProducer rabbitMQProducer;
    private RabbitMQJsonProducer rabbitMQJsonProducer;

    public RabbitMQController(RabbitMQProducer rabbitMQProducer, RabbitMQJsonProducer rabbitMQJsonProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
        this.rabbitMQJsonProducer = rabbitMQJsonProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publishMessage(
            @RequestParam("message") String message
    ){
        rabbitMQProducer.sendMessage(message);
        return ResponseEntity.ok("Message published successfully!");
    }

    @PostMapping("/publish/json")
    public ResponseEntity<String> publishJsonMessage(
            @RequestBody User user
    ){
        rabbitMQJsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Message published successfully!");
    }
}
