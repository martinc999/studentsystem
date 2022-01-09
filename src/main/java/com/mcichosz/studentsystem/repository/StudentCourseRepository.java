package com.mcichosz.studentsystem.repository;

import com.mcichosz.studentsystem.model.StudentCourse;
import com.mcichosz.studentsystem.model.StudentCourseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, StudentCourseId> {
    @Query("SELECT c,s " +
            "FROM  Course c, Student s " +
            "WHERE s.id = :studentId")
    List<Object[]> getStudentCourses(@Param("studentId")Integer studentId);
}
