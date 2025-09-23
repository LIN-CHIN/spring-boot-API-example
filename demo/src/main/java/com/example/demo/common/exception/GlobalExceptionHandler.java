package com.example.demo.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.HttpRequestMethodNotSupportedException;

import com.example.demo.common.responses.GenericResponse;
import com.example.demo.common.responses.ResponseCode;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 處理預期內的業務異常 - 按照自定義的 code 和 message 輸出
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<GenericResponse<Object>> handleBusinessException(BusinessException e) {
        System.err.println("Business Exception: " + e.getMessage());
        GenericResponse<Object> response = GenericResponse.GetErrorResponse(
                e.getCode(),
                e.getMessage(),
                e.getDescription());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    /**
     * 處理 HTTP 405 Method Not Allowed 錯誤
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<GenericResponse<Object>> handleMethodNotSupportedException(
            HttpRequestMethodNotSupportedException e) {
        System.err.println("Method Not Supported Exception: " + e.getMessage());

        String errorMessage = String.format("請確認該Request Method 是否存在?",
                e.getMethod(), String.join(", ", e.getSupportedMethods()));

        GenericResponse<Object> response = GenericResponse.GetErrorResponse(
                ResponseCode.METHOD_NOT_ALLOWED.getCode(),
                errorMessage,
                ResponseCode.METHOD_NOT_ALLOWED.getDescription());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    /**
     * 處理所有其他非預期異常 - 統一返回 systemError
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericResponse<Object>> handleAllExceptions(Exception e) {
        System.err.println("Unexpected Exception: " + e.getMessage());
        e.printStackTrace(); // 記錄詳細錯誤信息到日誌

        GenericResponse<Object> response = GenericResponse.GetSystemErrorResponse(e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
