package com.cao.account.controller;

import com.cao.account.dto.AccountResponse;
import com.cao.account.dto.AddAccountRequest;
import com.cao.account.dto.AddAccountResponse;
import com.cao.account.service.AccountService;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
@Validated
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts/{userId}")
    public ResponseEntity<AccountResponse> getAllAccounts(
            @PathVariable
            @Pattern(regexp = "^[a-zA-Z0-9]{8}$", message = "Invalid userId format")
            String userId) {
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

    @PostMapping("/account")
    public ResponseEntity<AddAccountResponse> addAccount(@RequestBody AddAccountRequest request) {
        return ResponseEntity.ok(accountService.addAccount(request.getAccount()));
    }
}
