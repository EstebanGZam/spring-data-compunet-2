package co.edu.icesi.introspringboot2.service;

import co.edu.icesi.introspringboot2.entity.Professor;

import java.util.List;

public interface ProfessorService {
    Professor createProfessor(Professor professor) throws RuntimeException;

    List<Professor> getAllProfessors();
}
