package com.university.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.university.model.bean.Lecture;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record InstructorDto(

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Long id,

        @NotBlank(message = "instructor first name can't be blank")
        @JsonProperty(required = true)
        String firstName,

        @NotBlank(message = "instructor last name can't be blank")
        @JsonProperty(required = true)
        String lastName,

        @JsonIgnoreProperties({"instructor"})
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        List<Lecture> lectures,

        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        List<@Positive(message = "id mus be positive") Long> lectureIds
) { }
