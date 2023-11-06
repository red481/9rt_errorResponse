package com.example.errorResponse.controller;

import com.example.errorResponse.domain.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ApiResponse<T> {
    Status status;
    MetaData metaData;
    List<T> results;
    T result;

    Data data;

    public ApiResponse(int code, String message, T result) {
        this.result = result;
        this.status = new Status(code, message);
        this.metaData = new MetaData(1);

    }

    public ApiResponse(int code, String message, List<T> results) {
        this.status = new Status(code, message);
        this.metaData = new MetaData(results.size());
        this.results = results;
    }

    public ApiResponse(int code, String message, Data data) {
        this.status = new Status(code, message);
        this.data = data;
    }
}
