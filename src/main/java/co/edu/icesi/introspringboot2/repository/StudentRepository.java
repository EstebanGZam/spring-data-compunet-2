package co.edu.icesi.introspringboot2.repository;

import co.edu.icesi.introspringboot2.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByProgram(String program);

    Page<Student> findAll(Pageable pageable);

    Optional<Student> getStudentByCode(String code);
}
