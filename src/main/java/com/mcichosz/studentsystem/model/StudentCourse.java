package com.mcichosz.studentsystem.model;

import javax.persistence.*;
import javax.xml.transform.sax.SAXSource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity(name = "StudentCourse")
@Table(name = "students_courses")
public class StudentCourse {

    @EmbeddedId
    private StudentCourseId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("studentId")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("courseId")
    private Course course;

    @Column(name = "creation_dt")
    private Timestamp creationDt = new Timestamp(System.currentTimeMillis());

    private StudentCourse() {}

    public StudentCourse(StudentCourseId id, Student student, Course course, Timestamp creationDt) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.creationDt = creationDt;
    }

    //Getters and setters omitted for brevity

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        StudentCourse that = (StudentCourse) o;
        return Objects.equals(student.getId(), that.student.getId()) &&
                Objects.equals(course.getId(), that.course.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(student.getId(), course.getId());
    }

    public StudentCourseId getId() {
        return id;
    }

    public void setId(StudentCourseId id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Timestamp getCreationDt() {
        return creationDt;
    }

    public void setCreationDt(Timestamp creationDt) {
        this.creationDt = creationDt;
    }
}