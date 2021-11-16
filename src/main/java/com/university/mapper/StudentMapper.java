package com.university.mapper;

import com.university.dto.StudentDto;
import com.university.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    Student dtoToStudent(StudentDto studentDto);

    StudentDto studentToDto(Student student);

}
