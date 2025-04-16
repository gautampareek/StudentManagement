package com.musafir.student.service;

import com.musafir.student.dto.UserDto;
import com.musafir.student.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    List<UserDto> showAllUsers();
    User findByEmail(String email);

    void deleteUser(Long id);
}
