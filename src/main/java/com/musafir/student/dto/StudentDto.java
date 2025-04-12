package com.musafir.student.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long id;
    @NotEmpty(message = "First Name couldn't be empty")
    private String firstName;
    @NotEmpty(message = "Last Name couldn't be empty")
    private String lastName;
    @NotEmpty(message = "Email couldn't be empty")
    @Email(message = "E-mail Format is not correct")
    private String email;
}
