package com.CreateAccountService.rabbit.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Builder(toBuilder = true)
public class AccountCreator implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private int rg;
    private String name;
    private String dataNascimento;
    private AccountType accountType;
}
