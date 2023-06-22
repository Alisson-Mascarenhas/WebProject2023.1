package br.ucsal.apiHorarioacademico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ucsal.apiHorarioacademico.model.QuadroHorario;

@Repository
public interface QuadroHorarioRepository extends JpaRepository<QuadroHorario, Long> {

}
