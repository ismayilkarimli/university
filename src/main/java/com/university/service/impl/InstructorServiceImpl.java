package com.university.service.impl;

import com.university.exception.IllegalIdException;
import com.university.mapper.InstructorMapper;
import com.university.model.bean.Lecture;
import com.university.model.dto.InstructorDto;
import com.university.repository.InstructorRepository;
import com.university.repository.LectureRepository;
import com.university.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;
    private final LectureRepository lectureRepository;

    @Override
    @Transactional
    public Map<String, Long> createInstructor(InstructorDto dto) {
        var instructor = InstructorMapper.INSTANCE.dtoToInstructor(dto);
        List<Lecture> lectures = new ArrayList<>();
        if (dto.lectureIds() != null) {
            lectures = lectureRepository.findAllById(dto.lectureIds());
            if (dto.lectureIds().size() != lectures.size()) {
                throw new IllegalIdException("Some lecture id's don't exist");
            }
            lectures.forEach(lecture -> lecture.setInstructor(instructor));
        }
        instructor.setLectures(Set.copyOf(lectures));
        var savedInstructor = instructorRepository.save(instructor);
        lectureRepository.saveAll(lectures);
        return Collections.singletonMap("id", savedInstructor.getId());
    }

    @Override
    public InstructorDto getInstructor(Long id) {
        var instructor = instructorRepository.findById(id).orElseThrow();
        return InstructorMapper.INSTANCE.instructorToDto(instructor);
    }

    @Override
    @Transactional
    public InstructorDto updateInstructor(Long id, InstructorDto dto) {
        var instructor = instructorRepository.findById(id).orElseThrow();
        instructor.setFirstName(dto.firstName());
        instructor.setLastName(dto.lastName());
        List<Lecture> previousLectures = new ArrayList<>();
        List<Lecture> updatedLectures = new ArrayList<>();
        if (dto.lectureIds() != null) {
            updatedLectures = lectureRepository.findAllById(dto.lectureIds());
            if (dto.lectureIds().size() != updatedLectures.size()) {
                throw new IllegalIdException("Some lecture id's don't exist");
            }
            var ids = instructor.getLectures().stream().map(Lecture::getId).collect(Collectors.toList());
            previousLectures = lectureRepository.findAllById(ids);
            previousLectures.forEach(lecture -> lecture.setInstructor(null));
            updatedLectures.forEach(lecture -> lecture.setInstructor(instructor));
            instructor.setLectures(new HashSet<>(updatedLectures));
        }
        var updatedInstructor = instructorRepository.save(instructor);
        lectureRepository.saveAll(previousLectures);
        lectureRepository.saveAll(updatedLectures);
        return InstructorMapper.INSTANCE.instructorToDto(updatedInstructor);
    }

    @Override
    public void deleteInstructor(Long id) {
        instructorRepository.deleteById(id);
    }

}
