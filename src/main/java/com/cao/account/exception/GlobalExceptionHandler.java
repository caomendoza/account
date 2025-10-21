package com.cao.account.exception;

import com.cao.account.constants.ApiError;
import com.cao.account.dto.ErrorResponse;
import com.cao.account.exception.base.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND.value())
                .body(ErrorResponse.builder()
                        .code(ApiError.ACCOUNT_NOT_FOUND.getCode())
                        .status(ApiError.ACCOUNT_NOT_FOUND.getStatus())
                        .message(ex.getMessage())
                        .build());

    }
}
