package com.university.controller.impl;

import com.university.controller.LectureController;
import com.university.dto.LectureDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/lecture")
@RequiredArgsConstructor
public class LectureControllerImpl implements LectureController {

    @Override
    @PostMapping("")
    public ResponseEntity<Map<String, Long>> createLecture(@RequestBody LectureDto dto) {
        return null;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<LectureDto> getLecture(@PathVariable Long id) {
        return null;
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<LectureDto> updateLecture(@PathVariable Long id, LectureDto dto) {
        return null;
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteLecture(@PathVariable Long id) {
        return null;
    }
}
