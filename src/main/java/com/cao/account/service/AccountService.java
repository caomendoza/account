package com.cao.account.service;

import com.cao.account.dto.AccountResponse;
import com.cao.account.entities.Account;

import java.util.List;

public interface AccountService {

    List<Account> getAllAccounts();

    AccountResponse getAllSavingsAccounts(String username);

    List<Account> getAllCheckingsAccounts();

}

