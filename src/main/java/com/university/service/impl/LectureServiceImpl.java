package com.university.service.impl;

import com.university.dto.LectureDto;
import com.university.exception.IllegalIdException;
import com.university.mapper.LectureMapper;
import com.university.model.Student;
import com.university.repository.LectureRepository;
import com.university.repository.StudentRepository;
import com.university.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {

    private final LectureRepository lectureRepository;
    private final StudentRepository studentRepository;

    @Override
    @Transactional
    public Map<String, Long> createLecture(LectureDto dto) {
        var lecture = LectureMapper.INSTANCE.dtoToLecture(dto);
        List<Student> students = new ArrayList<>();
        if (dto.registeredStudentIds() != null) {
            students = studentRepository.findAllById(dto.registeredStudentIds());
            if (dto.registeredStudentIds().size() != students.size()) {
                throw new IllegalIdException("Some student ids don't exist");
            }
            students.forEach(student -> student.getLectures().add(lecture));
            lecture.setStudents(Set.copyOf(students));
        }
        var savedLecture = lectureRepository.save(lecture);
        studentRepository.saveAll(students);
        return Collections.singletonMap("id", savedLecture.getId());
    }

    @Override
    public LectureDto getLecture(Long id) {
        var lecture = lectureRepository.findById(id).orElseThrow();
        return LectureMapper.INSTANCE.lectureToDto(lecture);
    }

    @Override
    @Transactional
    public LectureDto updateLecture(Long id, LectureDto dto) {
        var lecture = lectureRepository.findById(id).orElseThrow();
        lecture.setCourseName(dto.courseName());
        lecture.setDayOfWeek(dto.dayOfWeek());
        lecture.setStartTime(dto.startTime());
        lecture.setEndTime(dto.endTime());
        List<Student> students = new ArrayList<>();
        List<Student> updatedRegisteredStudents = new ArrayList<>();
        if (dto.registeredStudentIds() != null) {
            updatedRegisteredStudents = studentRepository.findAllById(dto.registeredStudentIds());
            if (dto.registeredStudentIds().size() != updatedRegisteredStudents.size()) {
                throw new IllegalIdException("Some student ids don't exist");
            }
            students = studentRepository.findAll();
            students.forEach(student -> student.getLectures().remove(lecture));
            updatedRegisteredStudents.forEach(student -> student.getLectures().add(lecture));
            lecture.setStudents(new HashSet<>(updatedRegisteredStudents));
        }
        var updatedLecture = lectureRepository.save(lecture);
        studentRepository.saveAll(students);
        studentRepository.saveAll(updatedRegisteredStudents);
        return LectureMapper.INSTANCE.lectureToDto(updatedLecture);
    }

    @Override
    public void deleteLecture(Long id) {
        lectureRepository.deleteById(id);
    }

}
