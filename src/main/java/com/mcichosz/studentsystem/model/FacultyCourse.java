package com.mcichosz.studentsystem.model;
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
    @MapsId("courseId")
    private Course course;

    @Column(name = "created_on")
    private Date createdOn = new Date();

    private FacultyCourse() {}

    public FacultyCourse(FacultyCourseId id, Faculty faculty, Course course, Date createdOn) {
        this.id = id;
        this.faculty = faculty;
        this.course = course;
        this.createdOn = createdOn;
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
}