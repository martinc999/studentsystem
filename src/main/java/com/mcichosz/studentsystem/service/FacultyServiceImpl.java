package com.mcichosz.studentsystem.service;

import com.mcichosz.studentsystem.model.Faculty;
import com.mcichosz.studentsystem.repository.CourseRepository;
import com.mcichosz.studentsystem.repository.FacultyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public Faculty save(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public List<Faculty> getAllCourses() {
        return facultyRepository.findAll();
    }

    @Override
    public void deleteAll() {
        facultyRepository.deleteAll();
    }

    @Override
    public Long count() {
        return facultyRepository.count();
    }

    @Override
    public Integer max() {
        return facultyRepository.max();
    }
}
