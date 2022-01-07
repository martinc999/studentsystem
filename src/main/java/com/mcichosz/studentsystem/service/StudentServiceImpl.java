package com.mcichosz.studentsystem.service;

import com.mcichosz.studentsystem.model.Student;
import com.mcichosz.studentsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;


    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Long min() {
        return studentRepository.min();
    }

    @Override
    public Long max() {
        return studentRepository.max();
    }

    @Override
    public void deleteAll() {
        studentRepository.deleteAll();
    }

}
