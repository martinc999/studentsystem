package com.mcichosz.studentsystem.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private java.sql.Timestamp creationDt;

    @OneToMany(
            mappedBy = "course",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<FacultyCourse> faculties = new ArrayList<>();

    @OneToMany(
            mappedBy = "course",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<StudentCourse> students = new ArrayList<>();

    public Course() {
    }

    public Course(Integer id, String name, String description, Timestamp creationDt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDt = creationDt;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Course course = (Course) o;
        return Objects.equals(id, course.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreationDt() {
        return creationDt;
    }

    public void setCreationDt(Timestamp creationDt) {
        this.creationDt = creationDt;
    }

    public List<FacultyCourse> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<FacultyCourse> faculties) {
        this.faculties = faculties;
    }

    public List<StudentCourse> getStudents() {
        return students;
    }

    public void setStudents(List<StudentCourse> students) {
        this.students = students;
    }

    public String toString() {
        return this.id +
                " " +
                this.name +
                " " +
                this.description;
    }

}
