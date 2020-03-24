package com.bankService.v1.business;


import com.bankService.v1.infrastructure.rabbit.response.CreateAccountRequest;
import com.bankService.v1.infrastructure.redis.BankAccountRedisInfrastructure;
import com.bankService.v1.infrastructure.redis.entity.BankAccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountBusiness {
    @Autowired
    BankAccountRedisInfrastructure bankAccountRedisInfraestructure;

    public BankAccountEntity createAccount(BankAccountEntity entity){
        return bankAccountRedisInfraestructure.save( BankAccountEntity.builder()
                .id(entity.getId())
                .rg(entity.getRg())
                .accountType(entity.getAccountType())
                .name(entity.getName())
                .dataNascimento(entity.getDataNascimento())
                .build());
    }
}
