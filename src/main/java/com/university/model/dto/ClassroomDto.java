package com.university.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.university.model.bean.Lecture;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;

public record ClassroomDto(

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Long id,

        @NotBlank(message = "room number can't be blank")
        @Positive
        @JsonProperty(required = true)
        Integer roomNumber,

        @NotBlank(message = "floor can't be blank")
        @JsonProperty(required = true)
        Integer floor,

        @NotBlank(message = "room capacity can't be blank")
        @Min(value = 10, message = "room capacity can't be less than 10")
        @JsonProperty(required = true)
        Integer capacity,

        @JsonIgnoreProperties({"classroom"})
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        List<Lecture> lectures,

        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        List<@Positive(message = "lecture id can't be negative") Long> lectureIds
) { }
