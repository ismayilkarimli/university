package com.university.service.impl;

import com.university.dto.LectureDto;
import com.university.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {

    @Override
    public Map<String, Long> createLecture(LectureDto dto) {
        return null;
    }

    @Override
    public LectureDto getLecture(Long id) {
        return null;
    }

    @Override
    public LectureDto updateLecture(Long id, LectureDto dto) {
        return null;
    }

    @Override
    public void deleteLecture(Long id) {

    }

}
