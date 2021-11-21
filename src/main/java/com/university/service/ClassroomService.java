package com.university.service;

import com.university.model.dto.ClassroomDto;

import java.util.Map;

public interface ClassroomService {

    Map<String, Long> createClassroom(ClassroomDto dto);

    ClassroomDto getClassroom(Long id);

    ClassroomDto updateClassroom(Long id, ClassroomDto dto);

    void deleteClassroom(Long id);

}
