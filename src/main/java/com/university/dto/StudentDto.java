package com.university.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public record StudentDto(

        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        Long id,

        @NotBlank(message = "student first name cannot be blank")
        String firstName,

        @NotBlank(message = "student last name cannot be blank")
        String lastName
) { }
