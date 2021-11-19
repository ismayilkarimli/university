package com.university.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.university.model.Student;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

public record LectureDto(

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Long id,

        @NotBlank(message = "course name cannot be blank")
        @JsonProperty(required = true)
        String courseName,

        @NotBlank(message = "day of week cannot be blank")
        @JsonProperty(required = true)
        DayOfWeek dayOfWeek,

        @NotBlank(message = "course start time cannot be blank")
        @JsonProperty(required = true)
        @JsonFormat(pattern = "HH:mm")
        LocalTime startTime,

        @NotBlank(message = "course end time cannot be blank")
        @JsonFormat(pattern = "HH:mm")
        @JsonProperty(required = true)
        LocalTime endTime,

        @JsonIgnoreProperties({"lectures"})
        @JsonProperty(value = "students", access = JsonProperty.Access.READ_ONLY)
        List<Student> registeredStudents,

        @JsonProperty(value = "studentIds", access = JsonProperty.Access.WRITE_ONLY)
        List<@Min(value = 1, message = "student id must be a positive value") Long> registeredStudentIds
) { }
