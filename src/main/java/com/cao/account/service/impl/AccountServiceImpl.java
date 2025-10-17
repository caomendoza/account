package com.cao.account.service.impl;

import com.cao.account.dto.AccountResponse;
import com.cao.account.dto.AddAccountRequest;
import com.cao.account.entities.Account;
import com.cao.account.repository.AccountRepository;
import com.cao.account.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountResponse getAllAccounts(String userId) {
        List<Account> accounts = accountRepository.findByUserId(userId);
        AccountResponse response = new AccountResponse();
        response.setAccounts(accounts);
        return response;
    }

    @Override
    public AccountResponse getAllSavingsAccounts(String userId) {
        List<Account> accounts = accountRepository.findByUserId(userId);
        List<Account> sortedAccounts = accounts.stream()
                .filter(a -> "SA".equals(a.getAccountType()) && "ACTIVE".equals(a.getStatus()))
                .sorted(Comparator.comparing(Account::getAccountNumber))
                .collect(Collectors.toList());

        // TODO can change to model mapper
        AccountResponse response = new AccountResponse();
        response.setAccounts(sortedAccounts);
        return response;
    }

    @Override
    public AccountResponse getAllCheckingsAccounts(String userId) {
        List<Account> accounts = accountRepository.findByUserId(userId);
        List<Account> sortedAccounts = accounts.stream()
                .filter(a -> "CA".equals(a.getAccountType()) && "ACTIVE".equals(a.getStatus()))
                .sorted(Comparator.comparing(Account::getAccountNumber))
                .collect(Collectors.toList());

        // TODO can change to model mapper
        AccountResponse response = new AccountResponse();
        response.setAccounts(sortedAccounts);
        return response;
    }

    @Override
    public AccountResponse addAccounts(AddAccountRequest request) {
        return null;
    }
}
