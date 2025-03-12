package co.edu.icesi.introspringboot2.repository;

import co.edu.icesi.introspringboot2.entity.Enrollment;
import co.edu.icesi.introspringboot2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    List<Enrollment> findByStudent_Id(long id);

}