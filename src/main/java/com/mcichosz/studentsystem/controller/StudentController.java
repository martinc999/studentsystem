package com.mcichosz.studentsystem.controller;

import com.mcichosz.studentsystem.model.Student;
import com.mcichosz.studentsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String add(@RequestBody Student student) {

        studentService.saveStudent(student);
        return "New student is added";
    }
    @GetMapping("/all")
    public List<Student> all() {
        return studentService.getAllStudents();
    }

}
