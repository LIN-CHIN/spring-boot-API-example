package com.example.demo.common.responses;

public enum ResponseCode {
    SUCCESS(0, "成功");

    private final int code;
    private final String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
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
