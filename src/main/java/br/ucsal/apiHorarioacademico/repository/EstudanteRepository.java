package br.ucsal.apiHorarioacademico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ucsal.apiHorarioacademico.model.Estudante;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

	Estudante findByMatricula(String matricula);
    
}