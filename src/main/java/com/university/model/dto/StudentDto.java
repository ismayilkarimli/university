package com.university.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.university.model.bean.Lecture;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;

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
        List<@Positive(message = "lecture id must be a positive value") Long> registeredLectureIds
) { }
