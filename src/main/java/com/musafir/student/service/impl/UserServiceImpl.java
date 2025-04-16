package com.musafir.student.service.impl;

import com.musafir.student.dto.UserDto;
import com.musafir.student.entity.Role;
import com.musafir.student.entity.User;
import com.musafir.student.repo.RoleRepo;
import com.musafir.student.repo.UserRepo;
import com.musafir.student.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;
    private RoleRepo roleRepo;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDto createUser(UserDto userDto) {
        User requestUser = modelMapper.map(userDto,User.class);
        requestUser.setPassword(passwordEncoder.encode(requestUser.getPassword()));

        String roleString = "";
        roleString = userDto.isMember() ? "ROLE_ADMIN":"ROLE_USER";
        String finalRoleString = roleString;
        Role role = roleRepo.findByRoleName(finalRoleString)
                .orElseGet(() -> {
                    Role newRole = new Role();
                    newRole.setRoleName(finalRoleString);
                    return newRole;
                });
        requestUser.setRoles(List.of(role));

        return modelMapper.map(userRepo.save(requestUser),UserDto.class);
    }

    @Override
    public List<UserDto> showAllUsers() {
        return userRepo.findAll().stream().map(user -> modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
