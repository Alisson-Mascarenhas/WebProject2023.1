package br.ucsal.apiHorarioacademico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ucsal.apiHorarioacademico.model.Professor;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

	Professor findByMatricula(String matricula);

}
