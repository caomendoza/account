package com.cao.account.controller;

import com.cao.account.dto.AccountResponse;
import com.cao.account.dto.AddAccountRequest;
import com.cao.account.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public ResponseEntity<AccountResponse> getAllAccounts(@RequestParam String userId) {
        // TODO change to a customer response entity for customization
        return ResponseEntity.ok(accountService.getAllAccounts(userId));
    }

    @GetMapping("/accounts/{userId}/savings")
    public ResponseEntity<AccountResponse> getAllSavingsAccounts(@PathVariable String userId) {
        // TODO change to a customer response entity for customization
        return ResponseEntity.ok(accountService.getAllSavingsAccounts(userId));
    }

    @GetMapping("/accounts/{userId}/checking")
    public ResponseEntity<AccountResponse> getCheckingAccounts(@PathVariable String userId) {
        return ResponseEntity.ok(accountService.getAllCheckingsAccounts(userId));
    }

    @PostMapping("/accounts")
    public void addAccounts(@RequestBody AddAccountRequest request) {

    }
}
