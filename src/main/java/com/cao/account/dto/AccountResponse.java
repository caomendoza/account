package com.cao.account.dto;

import com.cao.account.entities.Account;
import lombok.Data;

import java.util.List;

@Data
public class AccountResponse {

    private List<Account> accounts;
}
