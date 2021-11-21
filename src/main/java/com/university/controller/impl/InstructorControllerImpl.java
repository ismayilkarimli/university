package com.university.controller.impl;

import com.university.controller.InstructorController;
import com.university.model.dto.InstructorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/instructor")
@RequiredArgsConstructor
public class InstructorControllerImpl implements InstructorController {

    @Override
    public ResponseEntity<Map<String, Long>> createInstructor(InstructorDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<InstructorDto> getInstructor(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<InstructorDto> updateInstructor(Long id, InstructorDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<HttpStatus> deleteInstructor(Long id) {
        return null;
    }

}
