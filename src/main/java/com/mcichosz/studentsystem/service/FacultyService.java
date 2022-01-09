package com.mcichosz.studentsystem.service;

import com.mcichosz.studentsystem.model.Faculty;

import java.util.List;


public interface FacultyService {
    Faculty save(Faculty faculty);
    List<Faculty> getAllCourses();
    void deleteAll();
    Long count();
    Integer max();
}
