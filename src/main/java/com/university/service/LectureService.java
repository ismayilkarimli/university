package com.university.service;

import com.university.model.dto.LectureDto;

import java.util.Map;

public interface LectureService {

    Map<String, Long> createLecture(LectureDto dto);

    LectureDto getLecture(Long id);

    LectureDto updateLecture(Long id, LectureDto dto);

    void deleteLecture(Long id);

}
