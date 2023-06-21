package br.ucsal.apiHorarioacademico.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudante")
public class Estudante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy = "estudante")
	private List<QuadroHorario> quadroHorarios = new ArrayList<>();

	@Column(name = "matricula")
	private String matricula;

	@Column(name = "nome")
	private String nome;

	@Column(name = "email")
	private String email;

	@Column(name = "ano_egresso")
	private int anoEgresso;

	public Estudante() {

	}

	public Estudante(String matricula, String nomeCompleto, String email, int anoEgresso) {
		this.matricula = matricula;
		this.nome = nomeCompleto;
		this.email = email;
		this.anoEgresso = anoEgresso;
	}

	public List<QuadroHorario> getQuadroHorarios() {
		return quadroHorarios;
	}

	public void setQuadroHorarios(List<QuadroHorario> quadroHorarios) {
		this.quadroHorarios = quadroHorarios;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAnoEgresso() {
		return anoEgresso;
	}

	public void setAnoEgresso(int anoEgresso) {
		this.anoEgresso = anoEgresso;
	}

}
