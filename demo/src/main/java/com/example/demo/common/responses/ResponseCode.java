package com.example.demo.common.responses;

public enum ResponseCode {
    SUCCESS(0, "成功"),
    SYSTEM_ERROR(1, "系统錯誤"),
    METHOD_NOT_ALLOWED(405, "方法不被支持"),
    NOT_FOUND_ID(10001, "找不到id"),
    NOT_FOUND_NAME(10002, "找不到name");

    private final int code;
    private final String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return message;
    }

    public static ResponseCode fromCode(int code) {
        for (ResponseCode s : ResponseCode.values()) {
            if (s.code == code)
                return s;
        }
        throw new IllegalArgumentException("Unknown code: " + code);
    }
}
