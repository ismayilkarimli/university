package com.university.controller.impl;

import com.university.controller.StudentController;
import com.university.dto.StudentDto;
import com.university.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentControllerImpl implements StudentController {

    private final StudentService studentService;

    @Override
    @PostMapping("")
    public ResponseEntity<Map<String, Long>> createStudent(@RequestBody StudentDto dto) {
        var id = studentService.createStudent(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable Long id) {
        var student = studentService.getStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @RequestBody StudentDto dto) {
        var updatedStudent = studentService.updateStudent(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedStudent);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
