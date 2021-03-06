package com.university.service.impl;

import com.university.model.dto.StudentDto;
import com.university.exception.IllegalIdException;
import com.university.mapper.StudentMapper;
import com.university.repository.LectureRepository;
import com.university.repository.StudentRepository;
import com.university.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final LectureRepository lectureRepository;

    @Override
    @Transactional
    public Map<String, Long> createStudent(StudentDto dto) {
        var student = StudentMapper.INSTANCE.dtoToStudent(dto);
        if (dto.registeredLectureIds() != null) {
            var lectures = lectureRepository.findAllById(dto.registeredLectureIds());
            if (dto.registeredLectureIds().size() != lectures.size()) {
                throw new IllegalIdException("Some lecture ids don't exist");
            }
            lectures.forEach(lecture -> lecture.getStudents().add(student));
            student.setLectures(Set.copyOf(lectures));
            lectureRepository.saveAll(lectures);
        }
        var savedStudent = studentRepository.save(student);
        return Collections.singletonMap("id", savedStudent.getId());
    }

    @Override
    public StudentDto getStudent(Long id) {
        var student = studentRepository.findById(id).orElseThrow();
        return StudentMapper.INSTANCE.studentToDto(student);
    }

    @Override
    public StudentDto getDailySchedule(Long id, String day) {
        var student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("no such student"));
        var lectures = student.getLectures().stream()
                .filter(lecture -> lecture.getDayOfWeek().toString().equals(day.toUpperCase()))
                .collect(Collectors.toSet());
        student.setLectures(lectures);
        return StudentMapper.INSTANCE.studentToDto(student);
    }

    @Override
    @Transactional
    public StudentDto updateStudent(Long id, StudentDto dto) {
        var student = studentRepository.findById(id).orElseThrow();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        if (dto.registeredLectureIds() != null) {
            var updatedRegisteredLectures = lectureRepository.findAllById(dto.registeredLectureIds());
            if (dto.registeredLectureIds().size() != updatedRegisteredLectures.size()) {
                throw new IllegalIdException("Some lecture ids don't exist");
            }
            var lectures = lectureRepository.findAll();
            lectures.forEach(lecture -> lecture.getStudents().remove(student));
            updatedRegisteredLectures.forEach(lecture -> lecture.getStudents().add(student));
            student.setLectures(new HashSet<>(updatedRegisteredLectures));
            lectureRepository.saveAll(lectures);
            lectureRepository.saveAll(updatedRegisteredLectures);
        }
        var updatedStudent = studentRepository.save(student);
        return StudentMapper.INSTANCE.studentToDto(updatedStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

}
