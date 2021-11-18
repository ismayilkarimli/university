package com.university.controller;

import com.university.dto.LectureDto;
import com.university.model.Lecture;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

public interface LectureController {

    ResponseEntity<Map<String, Long>> createLecture(LectureDto dto);

    ResponseEntity<LectureDto> getLecture(Long id);

    ResponseEntity<LectureDto> updateLecture(Long id, LectureDto dto);

    ResponseEntity<HttpStatus> deleteLecture(Long id);

}
