package com.university.controller.impl;

import com.university.controller.StudentController;
import com.university.dto.StudentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentControllerImpl implements StudentController {

    @Override
    @PostMapping("")
    public ResponseEntity<Map<String, Long>> createStudent(StudentDto dto) {
        return null;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudent(Long id) {
        return null;
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, StudentDto dto) {
        return null;
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(Long id) {
        return null;
    }
}
