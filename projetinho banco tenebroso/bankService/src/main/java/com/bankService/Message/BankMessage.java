package com.bankService.Message;

public enum BankMessage {
    INVALID_ACCOUNT("account id or account type not Found");

    private String message;

    BankMessage(String message){
        this.message = message;
    }


}
