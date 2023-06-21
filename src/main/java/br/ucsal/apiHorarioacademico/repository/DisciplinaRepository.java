package br.ucsal.apiHorarioacademico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ucsal.apiHorarioacademico.model.Disciplina;
import br.ucsal.apiHorarioacademico.model.Professor;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

	Disciplina findByCodigo(String codigo);

	List<Disciplina> findByprofessorResponsavel(Professor professor);
    
}
