package co.edu.icesi.introspringboot2.integration;

import co.edu.icesi.introspringboot2.entity.Course;
import co.edu.icesi.introspringboot2.entity.Professor;
import co.edu.icesi.introspringboot2.entity.Student;
import co.edu.icesi.introspringboot2.service.CourseService;
import co.edu.icesi.introspringboot2.service.EnrollmentService;
import co.edu.icesi.introspringboot2.service.ProfessorService;
import co.edu.icesi.introspringboot2.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
public class StudentServiceIntegrationTest {
    @Autowired
    private StudentService studentService;

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private CourseService courseService;

    @Test
    void getEnrolledStudents_WhenCourseHasStudents_ShouldReturnStudentList() {
        // Arrange
        var professor = new Professor();
        professor.setName("Andrew");
        professor = professorService.createProfessor(professor);

        var course = new Course();
        course.setName("Software V");
        course.setProfessor(professor);
        courseService.createCourse(course);

        var student1 = new Student();
        student1.setName("Pedro");
        student1.setCode("A00394040");
        student1.setProgram("SIS");
        studentService.createStudent(student1);

        var student2 = new Student();
        student2.setName("Maria");
        student2.setCode("A00394041");
        student2.setProgram("SIS");
        studentService.createStudent(student2);

        enrollmentService.enrollStudent(student1.getId(), course.getId());
        enrollmentService.enrollStudent(student2.getId(), course.getId());

        // Act
        List<Student> studentList = studentService.getStudentsByCourse(course);

        // Assert
        assertEquals(2, studentList.size());
    }
}
