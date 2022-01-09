package com.mcichosz.studentsystem.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name = "FacultyCourse")
@Table(name = "faculties_courses")
public class FacultyCourse {

    @EmbeddedId
    private FacultyCourseId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("facultyId")
    private Faculty faculty;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @MapsId("courseId")
    private Course course;

    @Column(name = "creation_dt")
    private Date creationDt = new Date();

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    private FacultyCourse() {}

    public FacultyCourse(FacultyCourseId id, Faculty faculty, Course course, Date creationDt) {
        this.id = id;
        this.faculty = faculty;
        this.course = course;
        this.creationDt = creationDt;
    }

    //Getters and setters omitted for brevity

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        FacultyCourse that = (FacultyCourse) o;
        return Objects.equals(faculty, that.faculty) &&
                Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty, course);
    }

    public FacultyCourseId getId() {
        return id;
    }

    public void setId(FacultyCourseId id) {
        this.id = id;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Date getCreationDt() {
        return creationDt;
    }

    public void setCreationDt(Date creationDt) {
        this.creationDt = creationDt;
    }
}