package com.cao.account.kafka;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountCreatedEventDto {

    private String eventId;
    private String timestamp;
    private String source;
    private String eventType;

    private String userId;
    private String accountName;
    private int accountNumber;
    private String accountType;
    private boolean primaryFlag;
    private BigDecimal balance;
    private String currency;
    private String status;

}
