package co.edu.icesi.introspringboot2.service.impl;

import co.edu.icesi.introspringboot2.entity.Course;
import co.edu.icesi.introspringboot2.entity.Enrollment;
import co.edu.icesi.introspringboot2.entity.Student;
import co.edu.icesi.introspringboot2.repository.EnrollmentRepository;
import co.edu.icesi.introspringboot2.repository.StudentRepository;
import co.edu.icesi.introspringboot2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final EnrollmentRepository enrollmentRepository;
    @Value("${app.pagination.size}")
    private int pageSize;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, EnrollmentRepository enrollmentRepository) {
        this.studentRepository = studentRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> getByProgram(String program) {
        return studentRepository.findByProgram(program);
    }

    @Override
    public Page<Student> findAll(int page) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return studentRepository.findAll(pageable);
    }

    @Override
    public List<Student> getStudentsByCourse(Course course) {
        List<Enrollment> enrollments = enrollmentRepository.findByCourse(course);
        return enrollments.stream().map(Enrollment::getStudent).collect(Collectors.toList());
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

}
