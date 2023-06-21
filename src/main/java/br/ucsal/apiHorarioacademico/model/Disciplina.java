package br.ucsal.apiHorarioacademico.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "disciplina")
public class Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "professor_id", referencedColumnName = "id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Professor professorResponsavel;

	@Column(name = "codigo")
	private String codigo;

	@Column(name = "nome")
	private String nome;

	@Column(name = "dia_horario")
	private LocalDateTime diaHorario;

	@OneToMany(mappedBy = "disciplina")
	private List<QuadroHorario> quadroHorarios = new ArrayList<>();

	public Disciplina() {
	}

	public Disciplina(String codigo, String nome, Professor professor) {
		this.codigo = codigo;
		this.nome = nome;
		this.professorResponsavel = professor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "America/Sao_Paulo")
	public LocalDateTime getDiaHorario() {
		return diaHorario;
	}

	public void setDiaHorario(LocalDateTime datahora) {
		this.diaHorario = datahora;
	}

	public Professor getProfessorResponsavel() {
		return professorResponsavel;
	}

	public void setProfessorResponsavel(Professor professorResponsavel) {
		this.professorResponsavel = professorResponsavel;
	}

	public List<QuadroHorario> getQuadroHorarios() {
		return quadroHorarios;
	}

	public void setQuadroHorarios(List<QuadroHorario> quadroHorarios) {
		this.quadroHorarios = quadroHorarios;
	}

}
