package com.mcichosz.studentsystem.console;

import com.mcichosz.studentsystem.model.Student;
import com.mcichosz.studentsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {
    private final StudentRepository repository;

    @Autowired
    public DatabaseLoader(StudentRepository repository) {
        this.repository = repository;
    }


    @Override
    public void run(String... args) throws Exception {
        insertStudents();
    }

    private void insertStudents() {
        Student student = new Student();
        student.setId(2L);
        student.setAddress("SuperAwesomeTitle");
        student.setName("MCF7");

        repository.save(student);
    }
}