package com.mcichosz.studentsystem.repository;

import com.mcichosz.studentsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "SELECT min(id) FROM Student")
    Long min();

    @Query(value = "SELECT max(id) FROM Student")
    Long max();

}
