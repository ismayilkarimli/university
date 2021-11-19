package com.university.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.university.model.Lecture;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

public record StudentDto(

        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        Long id,

        @NotBlank(message = "student first name cannot be blank")
        @JsonProperty(required = true)
        String firstName,

        @NotBlank(message = "student last name cannot be blank")
        @JsonProperty(required = true)
        String lastName,

        @JsonIgnoreProperties({"students"})
        @JsonProperty(value = "lectures", access = JsonProperty.Access.READ_ONLY)
        List<Lecture> registeredLectures,

        @JsonProperty(value = "lectureIds", access = JsonProperty.Access.WRITE_ONLY)
        List<@Min(value = 1, message = "lecture id must be a positive value") Long> registeredLectureIds
) { }
