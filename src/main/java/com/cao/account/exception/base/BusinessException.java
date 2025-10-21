package com.cao.account.exception.base;

import com.cao.account.constants.ApiError;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final ApiError apiError;

    public BusinessException(ApiError apiError) {
        super(apiError.getMessage());
        this.apiError = apiError;
    }

    public BusinessException(ApiError apiError, String customMessage) {
        super(customMessage);
        this.apiError = apiError;
    }

    public BusinessException(ApiError apiError, Throwable cause) {
        super(apiError.getMessage(), cause);
        this.apiError = apiError;
    }
}