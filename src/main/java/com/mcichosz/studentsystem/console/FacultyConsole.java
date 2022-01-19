package com.mcichosz.studentsystem.console;

import com.mcichosz.studentsystem.model.Faculty;
import com.mcichosz.studentsystem.repository.FacultyRepository;
import com.mcichosz.studentsystem.service.FacultyService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

//@Component
@Slf4j
@Order(3)
public class FacultyConsole implements CommandLineRunner {
    @Autowired
    private final FacultyRepository repository;

    @Autowired
    public FacultyConsole(FacultyRepository repository) {
        this.repository = repository;
    }

    @Autowired
    private FacultyService facultyService;


    @Override
    public void run(String... args) throws Exception {
        try {
            Long count_ = facultyService.count();
            log.info("courseService----{}", count_);
            if (count_!=10) {
                facultyService.deleteAll();
                insertFaculties();
            }

        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new Exception("");
        }
    }

    private void insertFaculties() {
        Faculty faculty = new Faculty();

        for (int i = 0; i < 10; i++) {
            faculty.setId(i);
            faculty.setName("Faculty_" + i);
            String generatedString = RandomStringUtils.randomAlphabetic(10);
            faculty.setDescription("Faculty description_" + generatedString);
            faculty.setCreationDt(new Timestamp(System.currentTimeMillis()));
            facultyService.save(faculty);
            log.info("added {}", faculty.toString());
        }


    }
//    private void retrieveStudentsStats() {
//        log.info("max={}, min={}",studentService.max(), studentService.min());
//    }
//
//    private void deleteAll() {
//        studentService.deleteAll();
//    }
}