package com.mcichosz.studentsystem.service;

import com.mcichosz.studentsystem.model.Course;
import com.mcichosz.studentsystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteAll() {
        courseRepository.deleteAll();
    }

    @Override
    public Long count() {
        return courseRepository.count();
    }

}
