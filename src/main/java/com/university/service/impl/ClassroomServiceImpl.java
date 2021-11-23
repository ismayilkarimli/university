package com.university.service.impl;

import com.university.exception.IllegalIdException;
import com.university.mapper.ClassroomMapper;
import com.university.model.bean.Lecture;
import com.university.model.dto.ClassroomDto;
import com.university.repository.ClassroomRepository;
import com.university.repository.LectureRepository;
import com.university.service.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClassroomServiceImpl implements ClassroomService {

    private final ClassroomRepository classroomRepository;
    private final LectureRepository lectureRepository;

    @Override
    @Transactional
    public Map<String, Long> createClassroom(ClassroomDto dto) {
        var classroom = ClassroomMapper.INSTANCE.dtoToClassroom(dto);
        List<Lecture> lectures = new ArrayList<>();
        if (dto.lectureIds() != null) {
            lectures = lectureRepository.findAllById(dto.lectureIds());
            if (dto.lectureIds().size() != lectures.size()) {
                throw new IllegalIdException("Some lectures ids don't exist");
            }
            lectures.forEach(lecture -> lecture.setClassroom(classroom));
        }
        classroom.setLectures(new HashSet<>(lectures));
        var savedClassroom = classroomRepository.save(classroom);
        lectureRepository.saveAll(lectures);
        return Collections.singletonMap("id", savedClassroom.getId());
    }

    @Override
    public ClassroomDto getClassroom(Long id) {
        var classroom = classroomRepository.findById(id).orElseThrow();
        return ClassroomMapper.INSTANCE.classroomToDto(classroom);
    }

    @Override
    @Transactional
    public ClassroomDto updateClassroom(Long id, ClassroomDto dto) {
        var classroom = classroomRepository.findById(id).orElseThrow();
        classroom.setCapacity(dto.capacity());
        classroom.setFloor(dto.floor());
        classroom.setRoomNumber(dto.roomNumber());
        List<Lecture> previousLectures = new ArrayList<>();
        List<Lecture> updatedLectures = new ArrayList<>();
        if (dto.lectureIds() != null) {
            updatedLectures = lectureRepository.findAllById(dto.lectureIds());
            if (dto.lectureIds().size() != updatedLectures.size()) {
                throw new IllegalIdException("Some lecture id's don't exist");
            }
            var ids = classroom.getLectures().stream().map(Lecture::getId).collect(Collectors.toList());
            previousLectures = lectureRepository.findAllById(ids);
            previousLectures.forEach(lecture -> lecture.setClassroom(null));
            updatedLectures.forEach(lecture -> lecture.setClassroom(classroom));
            classroom.setLectures(new HashSet<>(updatedLectures));
        }
        var updatedClassroom = classroomRepository.save(classroom);
        lectureRepository.saveAll(previousLectures);
        lectureRepository.saveAll(updatedLectures);
        return ClassroomMapper.INSTANCE.classroomToDto(updatedClassroom);
    }

    @Override
    public void deleteClassroom(Long id) {
        classroomRepository.deleteById(id);
    }

}
