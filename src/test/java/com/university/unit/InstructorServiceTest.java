package com.university.unit;

import com.university.mapper.InstructorMapper;
import com.university.model.bean.Instructor;
import com.university.model.dto.InstructorDto;
import com.university.repository.InstructorRepository;
import com.university.repository.LectureRepository;
import com.university.service.InstructorService;
import com.university.service.impl.InstructorServiceImpl;
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
public class InstructorServiceTest {

    @Mock
    InstructorRepository instructorRepository;

    @Mock
    LectureRepository lectureRepository;

    @InjectMocks
    InstructorServiceImpl instructorService;

    @Test
    public void whenPostInstructor_shouldReturnMap() {
        Instructor instructor = Mockito.mock(Instructor.class);
        InstructorDto dto = InstructorMapper.INSTANCE.instructorToDto(instructor);

        when(instructorRepository.save(any(Instructor.class))).thenReturn(instructor);

        var map = instructorService.createInstructor(dto);

        assertThat(map.get("id")).isEqualTo(instructor.getId());
    }

    @Test
    public void whenGetInstructor_shouldReturnRequestedInstructor() {
        Instructor instructor = Mockito.mock(Instructor.class);

        when(instructorRepository.findById(instructor.getId())).thenReturn(Optional.of(instructor));

        var dto = instructorService.getInstructor(instructor.getId());

        assertThat(dto.id()).isEqualTo(instructor.getId());
    }

    @Test
    public void whenPutInstructor_shouldReturnSameInstructor() {
        Instructor instructor = Mockito.mock(Instructor.class);
        InstructorDto dto = InstructorMapper.INSTANCE.instructorToDto(instructor);

        when(instructorRepository.findById(instructor.getId())).thenReturn(Optional.of(instructor));
        when(instructorRepository.save(any(Instructor.class))).thenReturn(instructor);

        var updated = instructorService.updateInstructor(instructor.getId(), dto);

        assertThat(updated).isEqualTo(dto);
    }

    @Test
    public void whenDeleteInstructor_shouldDeleteInstructor() {
        Instructor instructor = Mockito.mock(Instructor.class);

        instructorService.deleteInstructor(instructor.getId());

        then(instructorRepository).should().deleteById(instructor.getId());
    }

}
