package com.mcichosz.studentsystem.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FacultyCourseId  implements Serializable {

    @Column(name = "faculty_id")
    private Integer facultyId;

    @Column(name = "course_id")
    private Integer courseId;

    private FacultyCourseId() {}

    public FacultyCourseId(Integer facultyId, Integer courseId) {
        this.facultyId = facultyId;
        this.courseId = courseId;
    }

//Getters omitted for brevity

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        FacultyCourseId that = (FacultyCourseId) o;
        return Objects.equals(facultyId, that.facultyId) &&
                Objects.equals(courseId, that.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facultyId, courseId);
    }
}