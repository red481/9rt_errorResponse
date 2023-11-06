package com.example.errorResponse.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MetaData {
    int resultCount;

    public MetaData(int resultCount){
        this.resultCount = resultCount;
    }
}
