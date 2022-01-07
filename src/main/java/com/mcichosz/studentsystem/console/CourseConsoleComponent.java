package com.mcichosz.studentsystem.console;

import com.mcichosz.studentsystem.model.Course;
import com.mcichosz.studentsystem.model.Student;
import com.mcichosz.studentsystem.repository.CourseRepository;
import com.mcichosz.studentsystem.repository.StudentRepository;
import com.mcichosz.studentsystem.service.CourseService;
import com.mcichosz.studentsystem.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@Slf4j
public class CourseConsoleComponent implements CommandLineRunner {
    private final CourseRepository repository;

    @Autowired
    public CourseConsoleComponent(CourseRepository repository) {
        this.repository = repository;
    }

    @Autowired
    private CourseService courseService;


    @Override
    public void run(String... args) throws Exception {
        try {
            Long count_ = courseService.count();
            log.info("courseService----{}", count_);
            if (count_!=10) {
                courseService.deleteAll();
                insertCourses();
            }
            //retrieveStudentsStats();

        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new Exception("");
        }
    }

    private void insertCourses() {
        Course course = new Course();

        for (long i = 0; i < 10; i++) {
            course.setId(i);
            course.setName("Name_" + i);
            course.setDescription("Description_" + i);
            course.setCreation_dt(new Timestamp(System.currentTimeMillis()));
            courseService.addCourse(course);
        }
        log.info("Test ------------");

    }
//    private void retrieveStudentsStats() {
//        log.info("max={}, min={}",studentService.max(), studentService.min());
//    }
//
//    private void deleteAll() {
//        studentService.deleteAll();
//    }
}