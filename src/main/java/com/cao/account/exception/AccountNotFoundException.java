package com.cao.account.exception;

import com.cao.account.constants.ApiError;
import com.cao.account.exception.base.BusinessException;

public class AccountNotFoundException extends BusinessException {

    public AccountNotFoundException() {
        super(ApiError.ACCOUNT_NOT_FOUND);
    }

    public AccountNotFoundException(String message) {
        super(ApiError.ACCOUNT_NOT_FOUND, message);
    }
}