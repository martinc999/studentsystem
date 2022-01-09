package com.mcichosz.studentsystem.service;

import com.mcichosz.studentsystem.model.StudentCourse;

import java.util.List;


public interface StudentCourseService {
    StudentCourse saveStudentCourseRel(StudentCourse studentCourse);

    List<StudentCourse> getAllStudentCourse();
    void refresh() throws Exception;
}
