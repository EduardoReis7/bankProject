package com.CreateAccountService.rabbit;

import com.CreateAccountService.rabbit.model.request.AccountCreator;
import com.CreateAccountService.rabbit.model.request.AccountType;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CreatingAccountProducerInfratruscture {
    private static final String ROUTING_KEY = "create";
    private static final String EXCHANGE = "exchange.project";

    @Autowired
    private Producer producer;
    Random gerador = new Random(19700621);

    @Scheduled(fixedDelay = 5000)
    public void sendMessage() throws JsonProcessingException {
        producer.send(AccountCreator.builder()
                .id(2)
                .accountType(AccountType.CORRENTE)
                .dataNascimento("04/04/1999")
                .name("os guli")
                .rg(gerador.nextInt(999))
                .build(),EXCHANGE,ROUTING_KEY);
    }

}
