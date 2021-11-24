package com.university.unit;

import com.university.mapper.StudentMapper;
import com.university.model.bean.Student;
import com.university.model.dto.StudentDto;
import com.university.repository.StudentRepository;
import com.university.service.impl.StudentServiceImpl;
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
public class StudentServiceTest {

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentServiceImpl studentService;

    @Test
    public void whenPostStudent_shouldReturnMap() {
        Student student = Mockito.mock(Student.class);
        StudentDto dto = StudentMapper.INSTANCE.studentToDto(student);

        when(studentRepository.save(any(Student.class))).thenReturn(student);

        var map = studentService.createStudent(dto);

        assertThat(map.get("id")).isEqualTo(student.getId());
    }

    @Test
    public void whenGetStudent_shouldReturnRequestedStudent() {
        Student student = Mockito.mock(Student.class);

        when(studentRepository.findById(student.getId())).thenReturn(Optional.of(student));

        var dto = studentService.getStudent(student.getId());

        assertThat(dto.id()).isEqualTo(student.getId());
    }

    @Test
    public void whenUpdateStudent_shouldReturnSameStudent() {
        Student student = Mockito.mock(Student.class);
        StudentDto dto = StudentMapper.INSTANCE.studentToDto(student);

        when(studentRepository.findById(student.getId())).thenReturn(Optional.of((student)));
        when(studentRepository.save(student)).thenReturn((student));

        var updated = studentService.updateStudent(student.getId(), dto);

        assertThat(updated).isEqualTo(dto);
    }

    @Test
    public void whenDeleteStudent_shouldDeleteStudent() {
        Student student = Mockito.mock(Student.class);

        studentService.deleteStudent(student.getId());

        then(studentRepository).should().deleteById(student.getId());
    }
}
