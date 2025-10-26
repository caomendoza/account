package com.cao.account.kafka.consumer;

import com.cao.account.entities.Account;
import com.cao.account.kafka.AccountCreatedEventDto;
import com.cao.account.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AccountEventConsumer {

    private final ObjectMapper objectMapper;

    private final AccountService accountService;

    public AccountEventConsumer(ObjectMapper objectMapper, AccountService accountService) {
        this.objectMapper = objectMapper;
        this.accountService = accountService;
    }

    @KafkaListener(topics = "account.kafka.topic", groupId = "account-service-group")
    public void listen(String message) {

        try {
            AccountCreatedEventDto event = objectMapper.readValue(message, AccountCreatedEventDto.class);

            Account account = Account.builder()
                    .userId(event.getUserId())
                    .accountName(event.getAccountName())
                    .accountNumber(event.getAccountNumber())
                    .accountType(event.getAccountType())
                    .primaryFlag(event.isPrimaryFlag())
                    .balance(event.getBalance())
                    .currency(event.getCurrency())
                    .status(event.getStatus())
                    .build();

            accountService.addAccount(account);
            System.out.println("Account saved from Kafka: " + account.getAccountNumber());

        } catch (Exception e) {
            System.err.println("Failed to process Kafka message: " + e.getMessage());
        }
    }
}
