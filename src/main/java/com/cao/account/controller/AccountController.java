package com.cao.account.controller;

import com.cao.account.dto.AccountRequest;
import com.cao.account.dto.AccountResponse;
import com.cao.account.entities.Account;
import com.cao.account.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAllAccounts() {
        // TODO change to a customer response entity for customization
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @PostMapping("/savings")
    public ResponseEntity<AccountResponse> getAllSavingsAccounts(@RequestBody AccountRequest request) {
        // TODO change to a customer response entity for customization
        return ResponseEntity.ok(accountService.getAllSavingsAccounts(request.getUsername()));
    }

    @GetMapping("/checking")
    public String getCheckingAccounts() {
        return "";
    }
}
