package com.musafir.student.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    @NotEmpty(message = "Name couldn't be empty")
    private String name;
    @Email
    @NotEmpty(message = "Name shouldn't be empty")
    private String email;
    @NotEmpty(message = "password shouldn't be empty")
    private String password;
    private boolean member;
}
