package com.mcichosz.studentsystem.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(name = "faculties")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private java.sql.Timestamp creationDt;

    @OneToMany(
            mappedBy = "faculty",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<FacultyCourse> courses = new ArrayList<>();

    public Faculty() {
    }

    public Faculty(Integer id, String name, String description, Timestamp creationDt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDt = creationDt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(id, faculty.id);
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

    public List<FacultyCourse> getCourses() {
        return courses;
    }

    public void setCourses(List<FacultyCourse> courses) {
        this.courses = courses;
    }

    public String toString() {
        return this.id + " " + this.name + " " + this.description + " " + this.creationDt;
    }
}
