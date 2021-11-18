package com.university.service.impl;

import com.university.dto.StudentDto;
import com.university.mapper.StudentMapper;
import com.university.repository.StudentRepository;
import com.university.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Map<String, Long> createStudent(StudentDto dto) {
        var student = StudentMapper.INSTANCE.dtoToStudent(dto);
        var savedStudent = studentRepository.save(student);
        return Collections.singletonMap("id", savedStudent.getId());
    }

    @Override
    public StudentDto getStudent(Long id) {
        var student = studentRepository.findById(id).orElseThrow();
        var dto = StudentMapper.INSTANCE.studentToDto(student);
        return dto;
    }

    @Override
    public StudentDto updateStudent(Long id, StudentDto dto) {
        var student = studentRepository.findById(id).orElseThrow();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        var updatedStudent = studentRepository.save(student);
        var updatedDto = StudentMapper.INSTANCE.studentToDto(updatedStudent);
        return updatedDto;
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

}
