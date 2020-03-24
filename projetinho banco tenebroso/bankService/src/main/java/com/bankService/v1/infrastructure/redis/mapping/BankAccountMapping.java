package com.bankService.v1.infrastructure.redis.mapping;

import com.bankService.v1.infrastructure.rabbit.response.CreateAccountRequest;
import com.bankService.v1.infrastructure.redis.entity.AccountType;
import com.bankService.v1.infrastructure.redis.entity.BankAccountEntity;

public class BankAccountMapping {

    public static BankAccountEntity from(CreateAccountRequest request){
        return BankAccountEntity.builder()
                .id(request.getId())
                .rg(request.getRg())
                .name(request.getName())
                .dataNascimento(request.getDataNascimento())
                //TODO THROW NEW EXCEPTION FOR NULL ACCOUNT TYPE
                .accountType(request.getAccountType() == AccountType.POUPANCA ? AccountType.POUPANCA :
                        request.getAccountType() == AccountType.CORRENTE ? AccountType.CORRENTE :
                        request.getAccountType() == AccountType.SALARIO ? AccountType.SALARIO : null)
                .build();
    }

}
