package br.ucsal.apiHorarioacademico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ucsal.apiHorarioacademico.model.Estudante;
import br.ucsal.apiHorarioacademico.repository.EstudanteRepository;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/estudante")
public class EstudanteController {

	private EstudanteRepository estudanteRepository;

	@Autowired
	public EstudanteController(EstudanteRepository estudanteRepository) {
		this.estudanteRepository = estudanteRepository;
	}

	@GetMapping
	public String mostrarFormulario(Model model) {
        model.addAttribute("estudante", new Estudante());
        model.addAttribute("estudantes", estudanteRepository.findAll());
		return "cadastroEstudante";
	}

	@PostMapping
	public String cadastrarEstudante(HttpServletRequest request) {
		String matricula = request.getParameter("matricula");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		int anoEgresso = Integer.parseInt(request.getParameter("anoEgresso"));

		Estudante estudante = new Estudante(matricula, nome, email, anoEgresso);

		estudanteRepository.save(estudante);

		return "redirect:/estudante-confirmacao";
	}

}
