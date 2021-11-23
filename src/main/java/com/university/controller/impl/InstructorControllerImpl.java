package com.university.controller.impl;

import com.university.controller.InstructorController;
import com.university.model.dto.InstructorDto;
import com.university.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/instructor")
@RequiredArgsConstructor
public class InstructorControllerImpl implements InstructorController {

    private final InstructorService instructorService;

    @Override
    @PostMapping("")
    public ResponseEntity<Map<String, Long>> createInstructor(@Valid @RequestBody InstructorDto dto) {
        var id = instructorService.createInstructor(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<InstructorDto> getInstructor(@PathVariable Long id) {
        var instructor = instructorService.getInstructor(id);
        return ResponseEntity.status(HttpStatus.OK).body(instructor);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<InstructorDto> updateInstructor(@PathVariable Long id, @Valid @RequestBody InstructorDto dto) {
        var updatedInstructor = instructorService.updateInstructor(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedInstructor);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteInstructor(@PathVariable Long id) {
        instructorService.deleteInstructor(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
