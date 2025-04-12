package com.musafir.student.repo;

import com.musafir.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {
    //added a comment
}
