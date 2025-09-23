package com.example.demo.common.responses;

import lombok.Getter;
import lombok.Setter;

public class GenericResponse<T> extends BaseResponse {
    @Getter
    @Setter
    private T data;

    public GenericResponse(T data, int code, String message, String description) {
        this.data = data;
        this.setCode(code);
        this.setMessage(message);
        this.setDescription(description);
    }

    public static <T> GenericResponse<T> GetSuccessResponse(T data) {
        return new GenericResponse<T>(
                data,
                ResponseCode.SUCCESS.getCode(),
                null, // success 時 message 為 null
                ResponseCode.SUCCESS.getDescription()); // description 為狀態碼訊息
    }

    public static <T> GenericResponse<T> GetSystemErrorResponse(String exceptionMessage) {
        return new GenericResponse<T>(
                null, // error 時 data 為 null
                ResponseCode.SYSTEM_ERROR.getCode(),
                exceptionMessage, // message 為 Exception 的錯誤訊息
                ResponseCode.SYSTEM_ERROR.getDescription()); // description 為狀態碼訊息
    }

    public static <T> GenericResponse<T> GetErrorResponse(int code, String exceptionMessage, String description) {
        return new GenericResponse<T>(
                null, // error 時 data 為 null
                code,
                exceptionMessage, // message 為 Exception 的錯誤訊息
                description); // description 為狀態碼訊息
    }
}