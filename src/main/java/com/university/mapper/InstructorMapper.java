package com.university.mapper;

import com.university.model.bean.Instructor;
import com.university.model.dto.InstructorDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InstructorMapper {

    InstructorMapper INSTANCE = Mappers.getMapper(InstructorMapper.class);

    Instructor dtoToInstructor(InstructorDto dto);

    InstructorDto instructorToDto(Instructor instructor);

}
