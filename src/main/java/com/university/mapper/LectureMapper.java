package com.university.mapper;

import com.university.dto.LectureDto;
import com.university.model.Lecture;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LectureMapper {

    LectureMapper INSTANCE = Mappers.getMapper(LectureMapper.class);

    Lecture dtoToLecture(LectureDto lectureDto);

    LectureDto lectureToDto(Lecture lecture);
}
