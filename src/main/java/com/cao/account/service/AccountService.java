package com.cao.account.service;

import com.cao.account.dto.AccountResponse;
import com.cao.account.dto.AddAccountRequest;

import javax.security.auth.login.AccountNotFoundException;

public interface AccountService {

    AccountResponse getAllAccounts(String userId);

    AccountResponse getAllSavingsAccounts(String userId);

    AccountResponse getAllCheckingsAccounts(String userId);

    AccountResponse addAccounts(AddAccountRequest request);
}

