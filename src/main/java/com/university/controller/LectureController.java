package com.university.controller;

import com.university.model.dto.LectureDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface LectureController {

    ResponseEntity<Map<String, Long>> createLecture(LectureDto dto);

    ResponseEntity<LectureDto> getLecture(Long id);

    ResponseEntity<LectureDto> updateLecture(Long id, LectureDto dto);

    ResponseEntity<HttpStatus> deleteLecture(Long id);

}
