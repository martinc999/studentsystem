package com.mcichosz.studentsystem.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(name = "faculties")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private java.sql.Timestamp creation_dt;

    @OneToMany(
            mappedBy = "faculty",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<FacultyCourse> posts = new ArrayList<>();

    public Faculty() {
    }

    public Faculty(Long id, String name, String description, Timestamp creation_dt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creation_dt = creation_dt;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<FacultyCourse> getPosts() {
        return posts;
    }

    public void setPosts(List<FacultyCourse> posts) {
        this.posts = posts;
    }
}