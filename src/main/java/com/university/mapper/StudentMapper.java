package com.university.mapper;

import com.university.model.dto.StudentDto;
import com.university.model.bean.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(source = "registeredLectures", target = "lectures")
    Student dtoToStudent(StudentDto studentDto);

    @Mapping(source = "lectures", target = "registeredLectures")
    StudentDto studentToDto(Student student);

}
