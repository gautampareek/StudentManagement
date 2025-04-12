package com.musafir.student.config;

import com.cloudinary.Cloudinary;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class StudentConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
