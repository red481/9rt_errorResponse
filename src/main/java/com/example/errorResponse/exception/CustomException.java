package com.example.errorResponse.exception;



import com.example.errorResponse.ErrorCode;
import com.example.errorResponse.controller.Data;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{
    private ErrorCode errorCode;
    private Data data;

    public CustomException(ErrorCode errorCode, Data data){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
