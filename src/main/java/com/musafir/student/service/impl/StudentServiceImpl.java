package com.musafir.student.service.impl;

import com.musafir.student.dto.StudentDto;
import com.musafir.student.entity.Student;
import com.musafir.student.repo.StudentRepo;
import com.musafir.student.service.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private StudentRepo studentRepo;
    private ModelMapper modelMapper;


    @Override
    public List<StudentDto> getAllStudents() {
        return studentRepo.findAll().stream().map(e->modelMapper.map(e,StudentDto.class)).collect(Collectors.toList());
    }

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        return modelMapper.map(studentRepo.save(modelMapper.map(studentDto,Student.class)),StudentDto.class);
    }

    @Override
    public StudentDto getStudentById(Long id) {
        return modelMapper.map(studentRepo.findById(id).get(),StudentDto.class);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }
}
