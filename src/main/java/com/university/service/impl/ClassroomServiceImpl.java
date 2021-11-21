package com.university.service.impl;

import com.university.model.dto.ClassroomDto;
import com.university.service.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ClassroomServiceImpl implements ClassroomService {

    @Override
    public Map<String, Long> createClassroom(ClassroomDto dto) {
        return null;
    }

    @Override
    public ClassroomDto getClassroom(Long id) {
        return null;
    }

    @Override
    public ClassroomDto updateClassroom(Long id, ClassroomDto dto) {
        return null;
    }

    @Override
    public void deleteClassroom(Long id) {

    }

}
