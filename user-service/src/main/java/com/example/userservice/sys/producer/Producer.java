package com.example.userservice.sys.producer;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class Producer {
    RabbitTemplate rabbitTemplate;
    String topicExchange;
    String routingKey;

    public void sendMessage(NotificationMessage message){
        log.info("TopicExchange {}, RoutingKey {}", topicExchange, routingKey);
        log.info("Notification  --> {}", message);
        rabbitTemplate.convertAndSend(topicExchange,routingKey,message);
    }
}
