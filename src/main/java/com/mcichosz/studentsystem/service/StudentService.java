package com.mcichosz.studentsystem.service;

import com.mcichosz.studentsystem.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudents();
}
