package com.mcichosz.studentsystem.service;

import com.mcichosz.studentsystem.model.*;
import com.mcichosz.studentsystem.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Transactional
@Service
@Slf4j
public class FacultyCourseServiceImpl implements FacultyCourseService {

    private final FacultyCourseRepository facultyCourseRepository;
    private final FacultyRepository facultyRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public FacultyCourseServiceImpl(FacultyCourseRepository facultyCourseRepository, FacultyRepository facultyRepository, CourseRepository courseRepository) {
        this.facultyCourseRepository = facultyCourseRepository;
        this.facultyRepository = facultyRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public FacultyCourse save(FacultyCourse facultyCourse) {
        return facultyCourseRepository.save(facultyCourse);
    }

    @Override
    public List<FacultyCourse> getAllFacultyCourses() {
        return facultyCourseRepository.findAll();
    }

    @Override
    public void refresh() throws Exception {
        try {
            if (facultyCourseRepository.count()!=10) {
                List<Object[]> lst = facultyCourseRepository.getFacultyCourses(facultyRepository.max());
                for (Object[] o : lst) {
                    Course c = (Course) o[0];
                    Faculty f = (Faculty) o[1];
                    //all the classes: Course, Lesson, Progress and User have the toString() overridden with the database ID;
                    log.info("Student: {} Faculty: {} ", c.toString(), f.toString());
                    FacultyCourse facultyCourse = new FacultyCourse(new FacultyCourseId(c.getId(), f.getId()), f, c, new Timestamp(System.currentTimeMillis()));
                    facultyCourseRepository.save(facultyCourse);

                }
            }
            List<FacultyCourse> facultyCourses = facultyCourseRepository.findAll();
            facultyCourses.forEach(facultyCourse -> {
                log.info("{} {}",facultyCourse.getId().getFacultyId(), facultyCourse.getId().getCourseId());
                log.info("{}",facultyCourse.getFaculty().toString());
                log.info("{}",facultyCourse.getCourse().toString());
                    });

        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new Exception("");
        }
    }
}
