package com.bankService.v1.infrastructure.rabbit.response;

import com.bankService.v1.infrastructure.redis.entity.AccountType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CreateAccountRequest {

    private int id;
    private int rg;
    private String name;
    private String dataNascimento;
    private AccountType accountType;
}
