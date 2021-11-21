package com.university.controller;

import com.university.model.dto.InstructorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface InstructorController {

    ResponseEntity<Map<String, Long>> createInstructor(InstructorDto dto);

    ResponseEntity<InstructorDto> getInstructor(Long id);

    ResponseEntity<InstructorDto> updateInstructor(Long id, InstructorDto dto);

    ResponseEntity<HttpStatus> deleteInstructor(Long id);

}
