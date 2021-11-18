package com.university.service.impl;

import com.university.dto.LectureDto;
import com.university.mapper.LectureMapper;
import com.university.model.Lecture;
import com.university.repository.LectureRepository;
import com.university.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {

    private final LectureRepository lectureRepository;

    @Override
    public Map<String, Long> createLecture(LectureDto dto) {
        var lecture = LectureMapper.INSTANCE.dtoToLecture(dto);
        var savedLecture = lectureRepository.save(lecture);
        return Collections.singletonMap("id", savedLecture.getId());
    }

    @Override
    public LectureDto getLecture(Long id) {
        var lecture = lectureRepository.findById(id).orElseThrow();
        var dto = LectureMapper.INSTANCE.lectureToDto(lecture);
        return dto;
    }

    @Override
    public LectureDto updateLecture(Long id, LectureDto dto) {
        var lecture = lectureRepository.findById(id).orElseThrow();
        lecture.setCourseName(dto.courseName());
        lecture.setDayOfWeek(dto.dayOfWeek());
        lecture.setStartTime(dto.startTime());
        lecture.setEndTime(dto.endTime());
        var updatedLecture = lectureRepository.save(lecture);
        var updatedDto = LectureMapper.INSTANCE.lectureToDto(updatedLecture);
        return updatedDto;
    }

    @Override
    public void deleteLecture(Long id) {
        lectureRepository.deleteById(id);
    }

}
