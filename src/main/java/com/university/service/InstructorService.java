package com.university.service;

import com.university.model.dto.InstructorDto;

import java.util.Map;

public interface InstructorService {

    Map<String, Long> createInstructor(InstructorDto dto);

    InstructorDto getInstructor(Long id);

    InstructorDto updateInstructor(Long id, InstructorDto dto);

    void deleteInstructor(Long id);

}
