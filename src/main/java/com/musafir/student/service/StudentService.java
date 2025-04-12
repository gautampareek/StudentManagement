package com.musafir.student.service;

import com.musafir.student.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();
    StudentDto saveStudent(StudentDto studentDto);
    StudentDto getStudentById(Long id);
    void deleteStudent(Long id);
}
