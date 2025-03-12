package co.edu.icesi.introspringboot2.service.impl;

import co.edu.icesi.introspringboot2.entity.Student;
import co.edu.icesi.introspringboot2.repository.StudentRepository;
import co.edu.icesi.introspringboot2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Value("${app.pagination.size}")
    private int pageSize;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getByProgram(String program){
        return studentRepository.findByProgram(program);
    }

    @Override
    public Page<Student> findAll(int page){
        Pageable pageable = PageRequest.of(page, pageSize);
        return studentRepository.findAll(pageable);
    }

}
