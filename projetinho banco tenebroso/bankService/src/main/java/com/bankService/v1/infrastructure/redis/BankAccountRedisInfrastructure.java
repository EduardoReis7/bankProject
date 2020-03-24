package com.bankService.v1.infrastructure.redis;

import com.bankService.v1.infrastructure.redis.entity.AccountType;
import com.bankService.v1.infrastructure.redis.entity.BankAccountEntity;
import com.bankService.v1.infrastructure.redis.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankAccountRedisInfrastructure {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    public BankAccountEntity save(BankAccountEntity entity){
        return bankAccountRepository.save(entity.
                toBuilder()
                .id(entity.getId())
                .accountType(entity.getAccountType())
                .name(entity.getName())
                .rg(entity.getRg())
                .build()
        );
    }
    public BankAccountEntity findByAccountType(AccountType accountType){
        return bankAccountRepository.findByAccountType(accountType);
    }
}
