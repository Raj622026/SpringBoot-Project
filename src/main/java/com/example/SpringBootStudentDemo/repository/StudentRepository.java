package com.example.SpringBootStudentDemo.repository;

import com.example.SpringBootStudentDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student ,Long> {
}
