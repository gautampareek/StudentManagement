package com.musafir.student.controller;

import com.musafir.student.dto.StudentDto;
import com.musafir.student.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping("/view/{id}")
    @ResponseBody
    public StudentDto getStudentById(@PathVariable("id") Long id){
        return studentService.getStudentById(id);
    }

    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
    @GetMapping("edit/{id}")
    public String updateStudent(@PathVariable("id") Long id,Model model){
        StudentDto studentDto = studentService.getStudentById(id);
        model.addAttribute("student",studentDto);
        return "edit_student";
    }

    @GetMapping("/students")
    public String getAllStudents(Model model){
        List<StudentDto> studentDtoList = studentService.getAllStudents();
        model.addAttribute("students",studentDtoList);
        return "students";
    }
    @GetMapping("student/new")
    public String newStudent(Model model){
        StudentDto studentDto = new StudentDto();
        model.addAttribute("student",studentDto);
        return "create_student";
    }
    @PostMapping("/addStudents")
    public String saveStudent(@ModelAttribute("student") @Valid StudentDto studentDto,
                              BindingResult result,
                              Model model
                            ){
        if(result.hasErrors()){
            model.addAttribute("student",studentDto);
            System.out.println(result);
            return "create_student";
        }
        System.out.println(studentDto);
        studentService.saveStudent(studentDto);
        return "redirect:students";
    }

}
