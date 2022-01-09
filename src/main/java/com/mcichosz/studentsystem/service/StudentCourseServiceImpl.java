package com.mcichosz.studentsystem.service;

import com.mcichosz.studentsystem.model.Course;
import com.mcichosz.studentsystem.model.Student;
import com.mcichosz.studentsystem.model.StudentCourse;
import com.mcichosz.studentsystem.model.StudentCourseId;
import com.mcichosz.studentsystem.repository.CourseRepository;
import com.mcichosz.studentsystem.repository.StudentCourseRepository;
import com.mcichosz.studentsystem.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@Slf4j
public class StudentCourseServiceImpl implements StudentCourseService {

    private final StudentCourseRepository studentCourseRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public StudentCourseServiceImpl(StudentCourseRepository studentCourseRepository, StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentCourseRepository = studentCourseRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentCourseService studentCourseService;

    @Override
    public StudentCourse saveStudentCourseRel(StudentCourse studentCourse) {
        return studentCourseRepository.save(studentCourse);
    }

    @Override
    public List<StudentCourse> getAllStudentCourse() {
        return studentCourseRepository.findAll();
    }

    @Transactional
    public void refresh() throws Exception {
        try {
            List<Student> studentList = studentService.getAllStudents();
            List<Course> courseList = courseService.getAllCourses();

            //studentList.stream().forEach((student) -> log.info("{}",student.toString()));
            //courseList.stream().forEach((course) -> log.info("{}",course.toString()));

            List<Object[]> lst = studentCourseRepository.getStudentCourses(studentList.get(0).getId());
            for (Object[] o : lst) {
                Course c = (Course) o[0];
                Student s = (Student) o[1];
                //all the classes: Course, Lesson, Progress and User have the toString() overridden with the database ID;
                log.info("Student: {} Course: {} ",s.toString(),c.toString());
                StudentCourse studentCourse = new StudentCourse(new StudentCourseId(s.getId(), c.getId()), s, c, new Timestamp(System.currentTimeMillis()));
                studentCourseService.saveStudentCourseRel(studentCourse);

            }
            List<StudentCourse> studentCourses = studentCourseService.getAllStudentCourse();
            studentCourses.forEach(studentCourse -> {
                //log.info("{} {}",studentCourse.getId().getStudentId(), studentCourse.getId().getCourseId());
                log.info("{}",studentCourse.getStudent().toString());
                log.info("{}",studentCourse.getCourse().toString());
            });

        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new Exception("");
        }
    }
}
