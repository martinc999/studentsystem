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
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Component
@Slf4j
public class StudentCourseConsole implements CommandLineRunner {
    private final StudentCourseRepository studentCourseRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public StudentCourseConsole(StudentCourseRepository studentCourseRepository, StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentCourseRepository = studentCourseRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentCourseService studentCourseService;

    @Override
    public void run(String... args) throws Exception {
        studentCourseService.refresh();
    }
}