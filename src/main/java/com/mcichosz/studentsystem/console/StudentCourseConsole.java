package com.mcichosz.studentsystem.console;

import com.mcichosz.studentsystem.model.Course;
import com.mcichosz.studentsystem.model.Student;
import com.mcichosz.studentsystem.model.StudentCourse;
import com.mcichosz.studentsystem.model.StudentCourseId;
import com.mcichosz.studentsystem.repository.CourseRepository;
import com.mcichosz.studentsystem.repository.StudentCourseRepository;
import com.mcichosz.studentsystem.repository.StudentRepository;
import com.mcichosz.studentsystem.service.CourseService;
import com.mcichosz.studentsystem.service.StudentCourseService;
import com.mcichosz.studentsystem.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

//@Component
@Slf4j
@Order(4)
public class StudentCourseConsole implements CommandLineRunner {

    @Autowired
    private StudentCourseService studentCourseService;

    @Override
    public void run(String... args) throws Exception {
        studentCourseService.refresh();
    }
}