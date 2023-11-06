package com.example.errorResponse.controller;

import com.example.errorResponse.ErrorCode;
import com.example.errorResponse.domain.Student;
import com.example.errorResponse.exception.CustomException;
import com.example.errorResponse.service.StudentService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MainController {

    private final StudentService studentService;

    @PostMapping("/member")
    @ResponseBody
    public ApiResponse saveMember(@RequestBody Student student){
        if(Integer.parseInt(student.getGrade()) >= 6){
            throw new CustomException(ErrorCode.SERVER_ERROR, new Data(6));
        }
        log.info("in Controller : " + student.getName());
        Student result = studentService.saveStudent(student);

        return makeResponse(result);
    }

    @GetMapping("/members")
    @ResponseBody
    public ApiResponse selectAllMembers(){
        List<Student> result = studentService.findAll();
        return makeResponse(result);
    }

    @GetMapping("/member")
    @ResponseBody
    public ApiResponse selectMembersByInputGrade(String grade){
        List<Student> result = studentService.findStudent(grade);
        return makeResponse(result);
    }

    public <T> ApiResponse<T> makeResponse(T result){
        return new ApiResponse(ErrorCode.SERVER_OK.getCode(), "OK", result);
    }

    public <T> ApiResponse<T> makeResponse(List<T> result){
        return new ApiResponse(ErrorCode.SERVER_OK.getCode(), "OK", result);

    }

    @ResponseStatus(value = INTERNAL_SERVER_ERROR)
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ApiResponse customExceptionHandler(HttpServletResponse response, CustomException e){

        log.info("in Exception Handler : " + e.getMessage());
        return new ApiResponse(e.getErrorCode().getCode(), e.getMessage(), e.getData());

    }
}
