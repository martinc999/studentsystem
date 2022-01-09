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
    private java.sql.Timestamp creation_dt;

    @OneToMany(
            mappedBy = "course",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<FacultyCourse> course1 = new ArrayList<>();

    @OneToMany(
            mappedBy = "course",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<StudentCourse> course2 = new ArrayList<>();

    public Course() {
    }

    public Course(Integer id, String name, String description, Timestamp creation_dt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creation_dt = creation_dt;
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

    public Timestamp getCreation_dt() {
        return creation_dt;
    }

    public void setCreation_dt(Timestamp creation_dt) {
        this.creation_dt = creation_dt;
    }

    public List<FacultyCourse> getCourse1() {
        return course1;
    }

    public void setCourse1(List<FacultyCourse> course1) {
        this.course1 = course1;
    }

    public List<StudentCourse> getCourse2() {
        return course2;
    }

    public void setCourse2(List<StudentCourse> course2) {
        this.course2 = course2;
    }

    public String toString() {
        return this.id +
                " " +
                this.name +
                " " +
                this.description;
    }

}
