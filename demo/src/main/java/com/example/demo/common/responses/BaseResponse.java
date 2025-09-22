package com.example.demo.common.responses;

import lombok.Getter;
import lombok.Setter;

public abstract class BaseResponse {
    @Getter
    @Setter
    private int code;

    @Getter
    @Setter
    private String message;
}
