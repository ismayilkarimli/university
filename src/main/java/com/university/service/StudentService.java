package com.university.service;

import com.university.model.dto.StudentDto;

import java.time.DayOfWeek;
import java.util.Map;

public interface StudentService {

    Map<String, Long> createStudent(StudentDto dto);

    StudentDto getStudent(Long id);

    StudentDto getDailySchedule(Long id, String day);

    StudentDto updateStudent(Long id, StudentDto dto);

    void deleteStudent(Long id);

}
