package com.mcichosz.studentsystem.repository;

import com.mcichosz.studentsystem.model.Faculty;
import com.mcichosz.studentsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
    @Query(value = "SELECT max(id) FROM Faculty")
    Integer max();
}
