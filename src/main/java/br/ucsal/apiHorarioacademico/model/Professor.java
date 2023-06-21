package br.ucsal.apiHorarioacademico.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "matricula")
	private String matricula;

	@Column(name = "nome")
	private String nome;

	@Column(name = "email")
	private String email;

	@Column(name = "ano_egresso")
	private int anoEgresso;

	public Professor() {

	}

	public Professor(String matricula, String nomeCompleto, String email, int anoEgresso) {
		this.matricula = matricula;
		this.nome = nomeCompleto;
		this.email = email;
		this.anoEgresso = anoEgresso;
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
