package com.bankService.v1.infrastructure.rabbit;

import com.bankService.helper.RabbitQueueName;
import com.bankService.v1.business.BankAccountBusiness;
import com.bankService.v1.infrastructure.rabbit.response.CreateAccountRequest;
import com.bankService.v1.infrastructure.redis.mapping.BankAccountMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BankAccountConsumerInfrastructure {

    @Autowired
    private BankAccountBusiness bankAccountBusiness;

    @RabbitListener(queues = RabbitQueueName.QUEUE_REGISTER_ACCOUNT)
    public void receiveAccountCreation(@Payload CreateAccountRequest createAccountRequest){
        try {
            bankAccountBusiness.createAccount(BankAccountMapping.from(createAccountRequest));
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

//  TODO MESSAGE IF IS NULL
//    private static void creationIsValid(CreateAccountRequest createAccountRequest){
//        if(createAccountRequest.getId() == null || createAccountRequest.getAccountType() == null){
//
//        }
//    }

}
