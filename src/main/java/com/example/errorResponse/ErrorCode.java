package com.example.errorResponse;

public enum ErrorCode {
    SERVER_OK("OK", 2000),
    SERVER_ERROR("grade 는 6 이상을 입력 할 수 없습니다.", 500);

    private String message;
    private int code;

    ErrorCode(String message, int code){
        this.message = message;
        this.code = code;
    }

    public String getMessage(){
        return message;
    }

    public int getCode(){
        return code;
    }
}
