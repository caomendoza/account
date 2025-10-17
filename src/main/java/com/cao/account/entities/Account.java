package com.cao.account.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "account")
public class Account {

    @Id
    private int accountId;
    private String userId;
    private String accountName;
    private int accountNumber;
    private String accountType;
    private boolean primaryFlag;
    private BigDecimal balance;
    private String currency;
    private String status;


}
