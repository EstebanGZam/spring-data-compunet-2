package co.edu.icesi.introspringboot2.service;

import co.edu.icesi.introspringboot2.entity.Course;
import co.edu.icesi.introspringboot2.entity.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {
    void createStudent(Student student);

    List<Student> getByProgram(String program);

    Page<Student> findAll(int page);

    List<Student> getStudentsByCourse(Course course);

    List<Student> getAllStudents();
}
