package com.cao.account.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ApiError {

    /**
     * Business Exceptions
     **/
    ACCOUNT_NOT_FOUND("BE001", "Account not found", HttpStatus.NOT_FOUND),

    /**
     * Validation Exceptions
     **/
    INVALID_USER_ID("VE001", "Invalid user id", HttpStatus.BAD_REQUEST),
    MISSING_REQUIRED_FIELD("VE002", "Missing required field", HttpStatus.BAD_REQUEST),

    /**
     * Service Exceptions
     **/
    DATABASE_UNAVAILABLE("SE001", " Database server is unreachable", HttpStatus.SERVICE_UNAVAILABLE),
    EXTERNAL_API_TIMEOUT("SE002", "External API Timed out", HttpStatus.SERVICE_UNAVAILABLE),
    INTERNAL_ERROR("SE003", "Unexpected Server error", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String code;
    private final String message;
    private final HttpStatus status;
}
