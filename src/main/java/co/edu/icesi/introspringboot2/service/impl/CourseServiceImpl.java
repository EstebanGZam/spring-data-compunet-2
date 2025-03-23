package co.edu.icesi.introspringboot2.service.impl;

import co.edu.icesi.introspringboot2.entity.Course;
import co.edu.icesi.introspringboot2.entity.Enrollment;
import co.edu.icesi.introspringboot2.repository.CourseRepository;
import co.edu.icesi.introspringboot2.repository.EnrollmentRepository;
import co.edu.icesi.introspringboot2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(EnrollmentRepository enrollmentRepository, CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public Course createCourse(Course course) throws RuntimeException {
        // Verifica si el curso ya existe por nombre
        if (courseRepository.existsByName(course.getName())) {
            throw new RuntimeException("El curso ya existe");
        }

        // Guarda el curso en la base de datos
        return courseRepository.save(course);
    }

    @Override
    public List<Course> listCourseOfStudent(long studentId) {
        var enrollments = enrollmentRepository.findByStudent_Id(studentId);
        return enrollments.stream().map(Enrollment::getCourse).toList();
    }

    @Override
    public Course getCourseById(Long courseId) throws RuntimeException {
        Optional<Course> course = courseRepository.findById(courseId);
        return course.orElseThrow(() -> new RuntimeException("Course not found"));
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteCourse(long courseId) {
        if (!courseRepository.existsById(courseId)) {
            throw new RuntimeException("Course not found");
        }
        courseRepository.deleteById(courseId);
    }

}
