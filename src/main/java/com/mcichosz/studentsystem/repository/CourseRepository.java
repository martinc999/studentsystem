package com.mcichosz.studentsystem.repository;

import com.mcichosz.studentsystem.model.Course;
import com.mcichosz.studentsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
