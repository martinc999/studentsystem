package com.mcichosz.studentsystem.service;

import com.mcichosz.studentsystem.model.Course;

import java.util.List;


public interface CourseService {
    Course save(Course course);
    List<Course> getAllCourses();
    void deleteAll();
    Long count();
}
