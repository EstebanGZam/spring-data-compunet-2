package co.edu.icesi.introspringboot2.service;

import co.edu.icesi.introspringboot2.entity.Course;

import java.util.List;

public interface CourseService {
    Course createCourse(Course course) throws RuntimeException;

    List<Course> listCourseOfStudent(long studentId);

    Course getCourseById(Long courseId) throws RuntimeException;

    List<Course> getAllCourses();

    void deleteCourse(long courseId);

}
