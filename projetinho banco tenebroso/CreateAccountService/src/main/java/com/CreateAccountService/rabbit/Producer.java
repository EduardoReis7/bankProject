package com.CreateAccountService.rabbit;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    @Autowired
    private RabbitTemplate template;

    public void send(Object object, String exchange, String routingKey) throws JsonProcessingException {
        template.convertAndSend(exchange, routingKey, getJsonMessage(object));
    }

    private static String convertToJson(Object object) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsString(object);
    }

    private static Message getJsonMessage(Object object) throws JsonProcessingException{
        return MessageBuilder
                .withBody(convertToJson(object).getBytes())
                .andProperties(MessagePropertiesBuilder
                        .newInstance()
                        .setContentType("application/json")
                        .build())
                .build();
    }
}
