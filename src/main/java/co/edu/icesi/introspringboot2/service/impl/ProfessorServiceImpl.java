package co.edu.icesi.introspringboot2.service.impl;

import co.edu.icesi.introspringboot2.entity.Professor;
import co.edu.icesi.introspringboot2.repository.ProfessorRepository;
import co.edu.icesi.introspringboot2.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public Professor createProfessor(Professor professor) throws RuntimeException {
        // Verifica si el curso ya existe por nombre
        if (professorRepository.existsById(professor.getId())) {
            throw new RuntimeException("El curso ya existe");
        }

        // Guarda el curso en la base de datos
        return professorRepository.save(professor);
    }

    @Override
    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }
}
