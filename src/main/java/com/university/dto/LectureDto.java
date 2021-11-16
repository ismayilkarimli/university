package com.university.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.time.DayOfWeek;
import java.time.LocalTime;

public record LectureDto(

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Long id,

        @NotBlank(message = "course name cannot be blank")
        String courseName,

        @NotBlank(message = "day of week cannot be blank")
        DayOfWeek dayOfWeek,

        @NotBlank(message = "course start time cannot be blank")
        LocalTime startTime,

        @NotBlank(message = "course end time cannot be blank")
        LocalTime endTime
) {}
