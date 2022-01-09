package com.mcichosz.studentsystem.service;

import com.mcichosz.studentsystem.model.Student;

import java.util.List;


public interface StudentService {
    Student save(Student student);
    List<Student> getAllStudents();
    Integer min();
    Integer max();
    void deleteAll();

    Long count();
}
