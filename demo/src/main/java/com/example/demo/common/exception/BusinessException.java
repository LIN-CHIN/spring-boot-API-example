package com.example.demo.common.exception;

import com.example.demo.common.responses.ResponseCode;

public class BusinessException extends RuntimeException {
    private final int code;
    private final String description;
    private final String message;

    public BusinessException(ResponseCode responseCode, String message) {
        super(message);
        this.code = responseCode.getCode();
        this.description = responseCode.getDescription();
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getMessage() {
        return message;
    }
}
