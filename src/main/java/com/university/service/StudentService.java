package com.university.service;

import com.university.dto.StudentDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface StudentService {

    Map<String, Long> createStudent(StudentDto dto);

    StudentDto getStudent(Long id);

    StudentDto updateStudent(Long id, StudentDto dto);

    void deleteStudent(Long id);


}
