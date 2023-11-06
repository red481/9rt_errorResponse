package com.example.errorResponse.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Status {
    private int code;
    private String message;

    public Status(int code, String message){
        this.code = code;
        this.message = message;
    }
}
