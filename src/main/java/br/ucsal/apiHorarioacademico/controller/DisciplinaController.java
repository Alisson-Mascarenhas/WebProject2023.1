package br.ucsal.apiHorarioacademico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String mostrarFormulario(Model model) {
        model.addAttribute("disciplina", new Disciplina());
        model.addAttribute("professores", professorRepository.findAll());
        return "cadastrarDisciplina";
	}

	@PostMapping
	public String cadastrarDisciplina(Disciplina disciplina) {
		String codigo = disciplina.getCodigo();
		String nome = disciplina.getNome();
		String matriculaProfessor = disciplina.getProfessorResponsavel().getMatricula();

		Professor professor = encontrarProfessorPorMatricula(matriculaProfessor);

		if (professor != null) {
			Disciplina disci = new Disciplina(codigo, nome, professor);

			disciplinaRepository.save(disci);

			return "redirect:/cadastrarDisciplina";
		} else {
			return "redirect:/erro";
		}
	}

	private Professor encontrarProfessorPorMatricula(String matricula) {
		return professorRepository.findByMatricula(matricula);
	}
}
