package com.cao.account.dto;

import lombok.Data;

import java.util.List;

@Data
public class AddAccountRequest {

    private List<AddAccountRequest> addAccountRequestList;
}
