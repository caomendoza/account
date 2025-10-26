package com.cao.account.dto;

import com.cao.account.entities.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
public class AddAccountResponse {

    private Account account;
}
