package com.mcichosz.studentsystem.service;

import com.mcichosz.studentsystem.model.FacultyCourse;
import com.mcichosz.studentsystem.model.StudentCourse;

import java.util.List;


public interface FacultyCourseService {
    FacultyCourse save(FacultyCourse facultyCourse);
    List<FacultyCourse> getAllFacultyCourses();
    void refresh() throws Exception;
}
