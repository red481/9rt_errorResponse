package com.example.errorResponse.service;

import com.example.errorResponse.domain.Student;
import com.example.errorResponse.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> findStudent(String grade){
        return studentRepository.findByGrade(grade);
    }

    public List<Student> findAll(){
        List<Student> studentList = studentRepository.getStudents().stream()
                .sorted().collect(Collectors.toList());
        return studentList;
    }
}
