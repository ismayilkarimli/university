package com.university.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.university.model.bean.Lecture;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ClassroomDto(

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Long id,

        @NotNull(message = "room number can't be null")
        @Positive
        @JsonProperty(required = true)
        Integer roomNumber,

        @NotNull(message = "floor can't be null")
        @JsonProperty(required = true)
        Integer floor,

        @NotNull(message = "room capacity can't be null")
        @Min(value = 10, message = "room capacity can't be less than 10")
        @JsonProperty(required = true)
        Integer capacity,

        @JsonIgnoreProperties({"classroom"})
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        List<Lecture> lectures,

        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        List<@Positive(message = "lecture id can't be negative") Long> lectureIds
) { }
