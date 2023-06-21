package br.ucsal.apiHorarioacademico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ucsal.apiHorarioacademico.model.Disciplina;
import br.ucsal.apiHorarioacademico.model.Professor;
import br.ucsal.apiHorarioacademico.repository.DisciplinaRepository;
import br.ucsal.apiHorarioacademico.repository.ProfessorRepository;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/disciplina")
public class DisciplinaController {

	private final DisciplinaRepository disciplinaRepository;
	private final ProfessorRepository professorRepository;

	@Autowired
	public DisciplinaController(DisciplinaRepository disciplinaRepository, ProfessorRepository professorRepository) {
		this.disciplinaRepository = disciplinaRepository;
		this.professorRepository = professorRepository;
	}

	@GetMapping
	public String mostrarFormulario() {
		// Renderiza o formulário de cadastro de disciplina
		return "cadastrar-disciplina";
	}

	@PostMapping
	public String cadastrarDisciplina(HttpServletRequest request) {
		// Obtém os dados do formulário
		String codigo = request.getParameter("codigo");
		String nome = request.getParameter("nome");
		String matriculaProfessor = request.getParameter("matriculaProfessor");

		// Encontra o professor com a matrícula fornecida
		Professor professor = encontrarProfessorPorMatricula(matriculaProfessor);

		if (professor != null) {
			// Cria uma nova disciplina com o professor encontrado
			Disciplina disciplina = new Disciplina(codigo, nome, professor);

			// Salva a disciplina no banco de dados
			disciplinaRepository.save(disciplina);

			// Redireciona para uma página de confirmação ou outra ação desejada
			return "redirect:/disciplina-confirmacao";
		} else {
			// Caso o professor não seja encontrado, redireciona para uma página de erro
			return "redirect:/erro";
		}
	}

	private Professor encontrarProfessorPorMatricula(String matricula) {
		return professorRepository.findByMatricula(matricula);
	}
}
