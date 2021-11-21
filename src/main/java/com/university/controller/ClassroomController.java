package com.university.controller;

import com.university.model.dto.ClassroomDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ClassroomController {

    ResponseEntity<Map<String, Long>> createClassroom(ClassroomDto dto);

    ResponseEntity<ClassroomDto> getClassroom(Long id);

    ResponseEntity<ClassroomDto> updateClassroom(Long id, ClassroomDto dto);

    ResponseEntity<HttpStatus> deleteClassroom(Long id);

}
