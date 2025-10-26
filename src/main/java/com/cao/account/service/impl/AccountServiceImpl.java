package com.cao.account.service.impl;

import com.cao.account.dto.AccountResponse;
import com.cao.account.dto.AddAccountResponse;
import com.cao.account.entities.Account;
import com.cao.account.exception.AccountNotFoundException;
import com.cao.account.repository.AccountRepository;
import com.cao.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final RestTemplate restTemplate;

    private final AccountRepository accountRepository;

    public AccountServiceImpl(RestTemplate restTemplate, AccountRepository accountRepository) {
        this.restTemplate = restTemplate;
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountResponse getAllAccounts(String userId) {
        List<Account> accounts = accountRepository.findByUserId(userId);
        if (accounts.isEmpty()) {
            log.info("Account not found with userId {}", userId);
            throw new AccountNotFoundException();
        }
        AccountResponse response = new AccountResponse();
        response.setAccounts(accounts);
        return response;

    }

    @Override
    public AccountResponse getAllSavingsAccounts(String userId) {
        List<Account> accounts = accountRepository.findByUserId(userId);
        if (accounts.isEmpty()) {
            log.info("Account not found with userId {}", userId);
            throw new AccountNotFoundException();
        }
        List<Account> sortedAccounts = accounts.stream()
                .filter(a -> "SA".equals(a.getAccountType()) && "ACTIVE".equals(a.getStatus()))
                .sorted(Comparator.comparing(Account::getAccountNumber))
                .collect(Collectors.toList());

        AccountResponse response = new AccountResponse();
        response.setAccounts(sortedAccounts);
        return response;
    }

    @Override
    public AccountResponse getAllCheckingsAccounts(String userId) {
        List<Account> accounts = accountRepository.findByUserId(userId);
        if (accounts.isEmpty()) {
            log.info("Account not found with userId {}", userId);
            throw new AccountNotFoundException();
        }
        List<Account> sortedAccounts = accounts.stream()
                .filter(a -> "CA".equals(a.getAccountType()) && "ACTIVE".equals(a.getStatus()))
                .sorted(Comparator.comparing(Account::getAccountNumber))
                .collect(Collectors.toList());
        AccountResponse response = new AccountResponse();
        response.setAccounts(sortedAccounts);
        return response;
    }

    @Override
    public AddAccountResponse addAccount(Account account) {
        Account saved = accountRepository.save(account);
        return new AddAccountResponse(saved);
    }

}
