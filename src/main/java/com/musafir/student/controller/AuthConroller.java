package com.musafir.student.controller;

import com.musafir.student.dto.UserDto;
import com.musafir.student.entity.User;
import com.musafir.student.service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class AuthConroller {
    private UserService userService;
   
    @GetMapping("deleteUser/{id}")
    @ResponseBody
    public String tempDelete(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "Deleted successfully,check database";
    }

    @GetMapping("/showUser")
    public String showUsers(Model model){
        List<UserDto> users = userService.showAllUsers();
        model.addAttribute("users",users);
        return "users";
    }

    @GetMapping("/login")
    public String login(){
        return "index";
    }
    @PostMapping("/register/new")
    public String registerUser(@ModelAttribute("user") @Valid UserDto userDto,
                               BindingResult bindingResult,
                               Model model){
        User existingUser = userService.findByEmail(userDto.getEmail());
        if(existingUser != null){
            bindingResult.rejectValue("email",null,"Email already registered");
        }
        if(bindingResult.hasErrors()){
            model.addAttribute("user",userDto);
            System.out.println(userDto);
            return "register";
        }
        System.out.println(userDto);
        userService.createUser(userDto);
        return "redirect:/register?success";
    }
    @GetMapping("/")
    public String homePage(){
        return "index";
    }
    @GetMapping("/register")
    public String register(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("user",userDto);
        return "register";
    }

}
