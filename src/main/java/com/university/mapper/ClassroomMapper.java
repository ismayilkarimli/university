package com.university.mapper;

import com.university.model.bean.Classroom;
import com.university.model.dto.ClassroomDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClassroomMapper {

    ClassroomMapper INSTANCE = Mappers.getMapper(ClassroomMapper.class);

    Classroom dtoToClassroom(ClassroomDto dto);

    ClassroomDto classroomToDto(Classroom classroom);

}
