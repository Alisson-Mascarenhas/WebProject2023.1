package br.ucsal.apiHorarioacademico.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.ucsal.apiHorarioacademico.enums.DiaSemana;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "quadro_horario")
public class QuadroHorario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "disciplina_id", referencedColumnName = "id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Disciplina disciplina;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "estudante_id", referencedColumnName = "id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Estudante estudante;

	@ElementCollection
	@CollectionTable(name = "quadro_horario_dias", joinColumns = @JoinColumn(name = "quadro_horario_id"))
	@MapKeyColumn(name = "dia_semana")
	@Column(name = "horario")
	private Map<DiaSemana, String> horarios;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Map<DiaSemana, String> getHorarios() {
		return horarios;
	}

	public void setHorarios(Map<DiaSemana, String> horarios) {
		this.horarios = horarios;
	}

}
