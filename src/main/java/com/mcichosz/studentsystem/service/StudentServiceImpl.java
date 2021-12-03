package com.mcichosz.studentsystem.service;

import com.mcichosz.studentsystem.model.Student;
import com.mcichosz.studentsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;


    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
}
