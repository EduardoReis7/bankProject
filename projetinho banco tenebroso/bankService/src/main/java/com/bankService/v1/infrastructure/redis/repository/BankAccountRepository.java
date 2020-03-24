package com.bankService.v1.infrastructure.redis.repository;


import com.bankService.v1.infrastructure.redis.entity.AccountType;
import com.bankService.v1.infrastructure.redis.entity.BankAccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends CrudRepository<BankAccountEntity, String> {
    BankAccountEntity findByAccountType(AccountType accountType);
}
