package com.mcichosz.studentsystem.console;

import com.mcichosz.studentsystem.service.FacultyCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
@Slf4j
@Order(5)
public class FacultyCourseConsole implements CommandLineRunner {

    @Autowired
    private FacultyCourseService facultyCourseService;

    @Override
    public void run(String... args) throws Exception {
        facultyCourseService.refresh();
    }
}