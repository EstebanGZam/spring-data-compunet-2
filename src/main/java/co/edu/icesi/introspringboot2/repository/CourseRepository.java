package co.edu.icesi.introspringboot2.repository;

import co.edu.icesi.introspringboot2.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    boolean existsByName(String name);
}

