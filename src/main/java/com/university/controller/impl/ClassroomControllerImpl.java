package com.university.controller.impl;

import com.university.controller.ClassroomController;
import com.university.model.dto.ClassroomDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/classroom")
@RequiredArgsConstructor
public class ClassroomControllerImpl implements ClassroomController {

    @Override
    public ResponseEntity<Map<String, Long>> createClassroom(ClassroomDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<ClassroomDto> getClassroom(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ClassroomDto> updateClassroom(Long id, ClassroomDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<HttpStatus> deleteClassroom(Long id) {
        return null;
    }

}
