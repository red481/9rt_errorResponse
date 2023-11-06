package com.example.errorResponse.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Student implements Comparable<Student>{
    private String name;
    private String grade;

    public boolean equals(Student student){
        if(this.name.equals(student.getName()) && this.grade.equals(student.getGrade())){
            return true;
        }else{
            return false;
        }
    }

    public int compareTo(Student student){
        int myGrade = Integer.parseInt(this.getGrade());
        int opponentGrade = Integer.parseInt(student.getGrade());
        if(myGrade - opponentGrade > 0){
            return 1;
        }else if(myGrade - opponentGrade < 0){
            return -1;
        }else{
            return 0;
        }
    }
}
