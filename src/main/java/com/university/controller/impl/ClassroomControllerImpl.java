package com.university.controller.impl;

import com.university.controller.ClassroomController;
import com.university.model.dto.ClassroomDto;
import com.university.service.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/classroom")
@RequiredArgsConstructor
public class ClassroomControllerImpl implements ClassroomController {

    private final ClassroomService classroomService;

    @Override
    @PostMapping("")
    public ResponseEntity<Map<String, Long>> createClassroom(@Valid @RequestBody ClassroomDto dto) {
        var id = classroomService.createClassroom(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ClassroomDto> getClassroom(@PathVariable Long id) {
        var classroom = classroomService.getClassroom(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(classroom);
    }

    @Override
    @PutMapping("{id}")
    public ResponseEntity<ClassroomDto> updateClassroom(@PathVariable Long id, @Valid @RequestBody ClassroomDto dto) {
        var updatedClassroom = classroomService.updateClassroom(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedClassroom);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteClassroom(@PathVariable Long id) {
        classroomService.deleteClassroom(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
