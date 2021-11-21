package com.university.service.impl;

import com.university.model.dto.InstructorDto;
import com.university.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    @Override
    public Map<String, Long> createInstructor(InstructorDto dto) {
        return null;
    }

    @Override
    public InstructorDto getInstructor(Long id) {
        return null;
    }

    @Override
    public InstructorDto updateInstructor(Long id, InstructorDto dto) {
        return null;
    }

    @Override
    public void deleteInstructor(Long id) {

    }

}
