package com.mcichosz.studentsystem.console;

import com.mcichosz.studentsystem.model.Student;
import com.mcichosz.studentsystem.repository.StudentRepository;
import com.mcichosz.studentsystem.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StudentConsole implements CommandLineRunner {
    private final StudentRepository repository;

    @Autowired
    public StudentConsole(StudentRepository repository) {
        this.repository = repository;
    }

    @Autowired
    private StudentService studentService;

    @Override
    public void run(String... args) throws Exception {
        try {
            Long count_ = studentService.count();
            log.info("-----------count={}",count_);
            if (count_!=10) {
                studentService.deleteAll();
                insertStudents();
                retrieveStudentsStats();
            }

        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new Exception("");
        }
    }

    private void insertStudents() {
        Student student = new Student();

        for (int i = 0; i < 10; i++) {
            student.setId(i);
            student.setAddress("Student" + i);
            student.setName("Name_" + i);
            studentService.save(student);
        }
        log.info("Test ------------");

    }
    private void retrieveStudentsStats() {

        log.info("max={}, min={}",studentService.max(), studentService.min());
    }

}