package com.university.controller.impl;

import com.university.controller.LectureController;
import com.university.dto.LectureDto;
import com.university.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/lecture")
@RequiredArgsConstructor
public class LectureControllerImpl implements LectureController {

    private final LectureService lectureService;

    @Override
    @PostMapping("")
    public ResponseEntity<Map<String, Long>> createLecture(@RequestBody LectureDto dto) {
        var id = lectureService.createLecture(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<LectureDto> getLecture(@PathVariable Long id) {
        var lecture = lectureService.getLecture(id);
        return ResponseEntity.status(HttpStatus.OK).body(lecture);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<LectureDto> updateLecture(@PathVariable Long id, @RequestBody LectureDto dto) {
        var updatedLecture = lectureService.updateLecture(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedLecture);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteLecture(@PathVariable Long id) {
        lectureService.deleteLecture(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
