package com.university.unit;

import com.university.mapper.ClassroomMapper;
import com.university.model.bean.Classroom;
import com.university.model.dto.ClassroomDto;
import com.university.repository.ClassroomRepository;
import com.university.repository.LectureRepository;
import com.university.service.impl.ClassroomServiceImpl;
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
public class ClassroomServiceTest {

    @Mock
    ClassroomRepository classroomRepository;

    @Mock
    LectureRepository lectureRepository;

    @InjectMocks
    ClassroomServiceImpl classroomService;

    @Test
    public void whenPostClassroom_shouldReturnMap() {
        Classroom classroom = Mockito.mock(Classroom.class);
        ClassroomDto dto = ClassroomMapper.INSTANCE.classroomToDto(classroom);

        when(classroomRepository.save(any(Classroom.class))).thenReturn(classroom);

        var map = classroomService.createClassroom(dto);

        assertThat(map.get("id")).isEqualTo(classroom.getId());
    }

    @Test
    public void whenGetClassroom_shouldReturnRequestedClassroom() {
        Classroom classroom = Mockito.mock(Classroom.class);

        when(classroomRepository.findById(classroom.getId())).thenReturn(Optional.of(classroom));

        var dto = classroomService.getClassroom(classroom.getId());

        assertThat(dto.id()).isEqualTo(classroom.getId());
    }

    @Test
    public void whenPutClassroom_shouldReturnSameClassroom() {
        Classroom classroom = Mockito.mock(Classroom.class);
        ClassroomDto dto = ClassroomMapper.INSTANCE.classroomToDto(classroom);

        when(classroomRepository.findById(classroom.getId())).thenReturn(Optional.of(classroom));
        when(classroomRepository.save(any(Classroom.class))).thenReturn(classroom);

        var updated = classroomService.updateClassroom(classroom.getId(), dto);

        assertThat(updated).isEqualTo(dto);
    }

    @Test
    public void whenDeleteClassroom_shouldDeleteClassroom() {
        Classroom classroom = Mockito.mock(Classroom.class);

        classroomService.deleteClassroom(classroom.getId());

        then(classroomRepository).should().deleteById(classroom.getId());
    }
}
