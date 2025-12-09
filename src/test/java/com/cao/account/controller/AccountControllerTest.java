package com.cao.account.controller;

import com.cao.account.dto.AccountResponse;
import com.cao.account.entities.Account;
import com.cao.account.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = AccountController.class)
@AutoConfigureMockMvc(addFilters = false)
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private AccountService accountService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAccountById_returns200AndBody_whenAccountExists() throws Exception {
        Account account = Account.builder()
                .accountId(123)
                .userId("9f8e7d6c")
                .accountName("Main Payroll Account")
                .accountNumber(10020001)
                .accountType("CA")
                .primaryFlag(true)
                .balance(new BigDecimal("24500.75"))
                .currency("PHP")
                .status("ACTIVE")
                .build();

        List<Account> listOfAccounts = new ArrayList<>();
        listOfAccounts.add(account);
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setAccounts(listOfAccounts);

        Mockito.when(accountService.getAllAccounts("123")).thenReturn(accountResponse);

        mockMvc.perform(get("/api/v1/accounts/123"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.accounts[0].userId").value("9f8e7d6c"))
                .andExpect(jsonPath("$.accounts[0].accountName").value("Main Payroll Account"))
                .andExpect(jsonPath("$.accounts[0].balance").value(24500.75));
    }

}
