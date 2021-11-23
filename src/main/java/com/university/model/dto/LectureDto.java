package com.university.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.university.model.bean.Classroom;
import com.university.model.bean.Instructor;
import com.university.model.bean.Student;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record LectureDto(

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Long id,

        @NotBlank(message = "course name cannot be blank")
        @JsonProperty(required = true)
        String courseName,

        @NotNull(message = "day of the week cannot be null")
        @JsonProperty(required = true)
        DayOfWeek dayOfWeek,

        @NotNull(message = "course start time cannot be null")
        @JsonProperty(required = true)
        @JsonFormat(pattern = "HH:mm")
        LocalTime startTime,

        @NotNull(message = "course end time cannot be null")
        @JsonFormat(pattern = "HH:mm")
        @JsonProperty(required = true)
        LocalTime endTime,

        @JsonIgnoreProperties({"lectures"})
        @JsonProperty(value = "students", access = JsonProperty.Access.READ_ONLY)
        List<Student> registeredStudents,

        @JsonProperty(value = "studentIds", access = JsonProperty.Access.WRITE_ONLY)
        List<@Positive(message = "student id must be a positive value") Long> registeredStudentIds,

        @JsonIgnoreProperties({"lectures"})
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Instructor instructor,

        @Positive(message = "instructor id must be a positive value")
        Long instructorId,

        @JsonIgnoreProperties({"lectures"})
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Classroom classroom,

        @Positive(message = "classroom id must be a positive value")
        Long classroomId
) { }
