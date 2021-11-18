package com.university.controller;

import com.university.dto.StudentDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface StudentController {

    ResponseEntity<Map<String, Long>> createStudent(StudentDto dto);

    ResponseEntity<StudentDto> getStudent(Long id);

    ResponseEntity<StudentDto> updateStudent(Long id, StudentDto dto);

    ResponseEntity<HttpStatus> deleteStudent(Long id);

}
