package com.example.errorResponse.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Data {
    public static class InputRestriction{
        public static class MaxGrade{
            int maxGrade;

            public MaxGrade(int maxGrade){
                this.maxGrade = maxGrade;
            }
        }
    }

    public Data(){

    }

    public Data(int grade){
        InputRestriction.MaxGrade maxGrade = new InputRestriction.MaxGrade(grade);
    }
}
