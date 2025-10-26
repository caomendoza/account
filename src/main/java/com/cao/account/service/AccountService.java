package com.cao.account.service;

import com.cao.account.dto.AccountResponse;
import com.cao.account.dto.AddAccountResponse;
import com.cao.account.entities.Account;

public interface AccountService {

    AccountResponse getAllAccounts(String userId);

    AccountResponse getAllSavingsAccounts(String userId);

    AccountResponse getAllCheckingsAccounts(String userId);

    AddAccountResponse addAccount(Account account);
}

