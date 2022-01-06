package com.mcichosz.studentsystem.model;

import javax.persistence.*;
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

    @Column(name = "created_on")
    private Date createdOn = new Date();

    private StudentCourse() {}

    public StudentCourse(StudentCourseId id, Student student, Course course, Date createdOn) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.createdOn = createdOn;
    }

    //Getters and setters omitted for brevity

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        StudentCourse that = (StudentCourse) o;
        return Objects.equals(student, that.student) &&
                Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, course);
    }
}