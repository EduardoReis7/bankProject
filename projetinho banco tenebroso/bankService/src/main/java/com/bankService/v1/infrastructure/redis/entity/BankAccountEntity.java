package com.bankService.v1.infrastructure.redis.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("BankAccountEntity")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BankAccountEntity {
    @Id
    private int id;
    private String cpf;
    private int rg;
    private String name;
    private AccountType accountType;
    private String dataNascimento;
    private double saldo;
}
