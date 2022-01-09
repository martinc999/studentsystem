package com.mcichosz.studentsystem.repository;

import com.mcichosz.studentsystem.model.FacultyCourse;
import com.mcichosz.studentsystem.model.FacultyCourseId;
import com.mcichosz.studentsystem.model.StudentCourse;
import com.mcichosz.studentsystem.model.StudentCourseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyCourseRepository extends JpaRepository<FacultyCourse, FacultyCourseId> {
    @Query("SELECT c,f " +
            "FROM  Course c, Faculty f " +
            "WHERE f.id = :facultyId")
    List<Object[]> getFacultyCourses(@Param("facultyId")Integer facultyId);
}
