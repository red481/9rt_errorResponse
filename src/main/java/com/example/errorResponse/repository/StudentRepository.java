package com.example.errorResponse.repository;

import com.example.errorResponse.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Slf4j
public class StudentRepository {
    List<Student> students;

    public StudentRepository(){
        students = new ArrayList<Student>();
    }

    public List<Student> getStudents(){
        return students;
    }

    public Student save(Student student){
        log.info("in Repository : " + student.getName());
        students.add(student);
        return student;
    }

public List<Student> findByGrade(String grade){
        List<Student> student = students.stream()
                .filter(s -> s.getGrade().equals(grade))
                .collect(Collectors.toList());
        return student;
    }


}
