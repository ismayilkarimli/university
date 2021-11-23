package com.university.service.impl;

import com.university.model.bean.Classroom;
import com.university.model.bean.Instructor;
import com.university.model.dto.LectureDto;
import com.university.exception.IllegalIdException;
import com.university.mapper.LectureMapper;
import com.university.model.bean.Student;
import com.university.repository.ClassroomRepository;
import com.university.repository.InstructorRepository;
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
    private final InstructorRepository instructorRepository;
    private final ClassroomRepository classroomRepository;

    @Override
    @Transactional
    public Map<String, Long> createLecture(LectureDto dto) {
        var lecture = LectureMapper.INSTANCE.dtoToLecture(dto);
        List<Student> students = new ArrayList<>();
        Instructor instructor = new Instructor();
        Classroom classroom = new Classroom();
        if (dto.registeredStudentIds() != null) {
            students = studentRepository.findAllById(dto.registeredStudentIds());
            if (dto.registeredStudentIds().size() != students.size()) {
                throw new IllegalIdException("Some student ids don't exist");
            }
            students.forEach(student -> student.getLectures().add(lecture));
            lecture.setStudents(Set.copyOf(students));
        }
        if (dto.instructorId() != null) {
            instructor = instructorRepository.findById(dto.instructorId()).orElseThrow();
            instructor.getLectures().add(lecture);
            lecture.setInstructor(instructor);
        }
        if (dto.classroomId() != null) {
            classroom = classroomRepository.findById(dto.classroomId()).orElseThrow();
            classroom.getLectures().add(lecture);
            lecture.setClassroom(classroom);
        }
        var savedLecture = lectureRepository.save(lecture);
        studentRepository.saveAll(students);
        if (dto.instructorId() != null) {
            instructorRepository.save(instructor);
        }
        if (dto.classroomId() != null) {
            classroomRepository.save(classroom);
        }
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
        Instructor instructor = new Instructor();
        List<Instructor> instructors = new ArrayList<>();
        Classroom classroom = new Classroom();
        List<Classroom> classrooms = new ArrayList<>();
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
        if (dto.instructorId() != null) {
            instructor = instructorRepository.findById(dto.instructorId()).orElseThrow();
            instructors = instructorRepository.findAll();
            instructors.forEach(instructor1 -> instructor1.getLectures().remove(lecture));
            instructor.getLectures().add(lecture);
            lecture.setInstructor(instructor);
        }
        if (dto.classroomId() != null) {
            classroom = classroomRepository.findById(dto.classroomId()).orElseThrow();
            classrooms = classroomRepository.findAll();
            classrooms.forEach(room -> room.getLectures().remove(lecture));
            classroom.getLectures().add(lecture);
            lecture.setClassroom(classroom);
        }
        var updatedLecture = lectureRepository.save(lecture);
        studentRepository.saveAll(students);
        studentRepository.saveAll(updatedRegisteredStudents);
        if (dto.instructorId() != null) {
            instructorRepository.saveAll(instructors);
            instructorRepository.save(instructor);
        }
        if (dto.classroomId() != null) {
            classroomRepository.saveAll(classrooms);
            classroomRepository.save(classroom);
        }
        return LectureMapper.INSTANCE.lectureToDto(updatedLecture);
    }

    @Override
    public void deleteLecture(Long id) {
        lectureRepository.deleteById(id);
    }

}
