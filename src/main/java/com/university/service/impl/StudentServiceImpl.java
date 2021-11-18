package com.university.service.impl;

import com.university.dto.StudentDto;
import com.university.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Override
    public Map<String, Long> createStudent(StudentDto dto) {
        return null;
    }

    @Override
    public StudentDto getStudent(Long id) {
        return null;
    }

    @Override
    public StudentDto updateStudent(Long id, StudentDto dto) {
        return null;
    }

    @Override
    public void deleteStudent(Long id) {

    }

}
