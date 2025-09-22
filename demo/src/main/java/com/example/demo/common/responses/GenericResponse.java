package com.example.demo.common.responses;

import lombok.Getter;
import lombok.Setter;

public class GenericResponse<T> extends BaseResponse {
    @Getter
    @Setter
    private T data;

    public GenericResponse(T data, int code, String message) {
        this.data = data;
        this.setCode(code);
        this.setMessage(message);
    }

    public static <T> GenericResponse<T> GetSuccessResponse(T data) {
        return new GenericResponse<T>(
                data,
                ResponseCode.SUCCESS.getCode(),
                ResponseCode.SUCCESS.getMessage());
    }
}