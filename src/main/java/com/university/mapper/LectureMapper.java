package com.university.mapper;

import com.university.dto.LectureDto;
import com.university.model.Lecture;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LectureMapper {

    LectureMapper INSTANCE = Mappers.getMapper(LectureMapper.class);

    @Mapping(source = "registeredStudents", target = "students")
    Lecture dtoToLecture(LectureDto lectureDto);

    @Mapping(source = "students", target = "registeredStudents")
    LectureDto lectureToDto(Lecture lecture);

}
