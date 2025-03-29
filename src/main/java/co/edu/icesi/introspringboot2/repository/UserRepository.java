package co.edu.icesi.introspringboot2.repository;

import co.edu.icesi.introspringboot2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);  // Busca usuario por email
}
