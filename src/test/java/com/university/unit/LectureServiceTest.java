package com.university.unit;

import com.university.mapper.LectureMapper;
import com.university.model.bean.Lecture;
import com.university.model.dto.LectureDto;
import com.university.repository.LectureRepository;
import com.university.repository.StudentRepository;
import com.university.service.impl.LectureServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LectureServiceTest {

    @Mock
    LectureRepository lectureRepository;

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    LectureServiceImpl lectureService;

    @Test
    public void givenPostLecture_thenReturnMap() {
        Lecture lecture = Mockito.mock(Lecture.class);
        LectureDto dto = LectureMapper.INSTANCE.lectureToDto(lecture);

        when(lectureRepository.save(any(Lecture.class))).thenReturn(lecture);

        var map = lectureService.createLecture(dto);

        assertThat(map.get("id")).isEqualTo(lecture.getId());
    }

    @Test
    public void whenGetLecture_shouldReturnRequestedLecture() {
        Lecture lecture = Mockito.mock(Lecture.class);

        when(lectureRepository.findById(lecture.getId())).thenReturn(Optional.of(lecture));

        var dto = lectureService.getLecture(lecture.getId());

        assertThat(dto.id()).isEqualTo(lecture.getId());
    }

    @Test
    public void whenPutLecture_shouldReturnSameLecture() {
        Lecture lecture = Mockito.mock(Lecture.class);
        LectureDto dto = LectureMapper.INSTANCE.lectureToDto(lecture);

        when(lectureRepository.findById(lecture.getId())).thenReturn(Optional.of(lecture));
        when(lectureRepository.save(any(Lecture.class))).thenReturn(lecture);

        var updated = lectureService.updateLecture(lecture.getId(), dto);

        assertThat(updated).isEqualTo(dto);
    }

    @Test
    public void whenDeleteLecture_shouldDeleteLecture() {
        Lecture lecture = Mockito.mock(Lecture.class);

        lectureService.deleteLecture(lecture.getId());

        then(lectureRepository).should().deleteById(lecture.getId());
    }

}
