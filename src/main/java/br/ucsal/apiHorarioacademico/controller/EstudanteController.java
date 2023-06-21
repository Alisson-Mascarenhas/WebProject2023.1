package br.ucsal.apiHorarioacademico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String mostrarFormulario() {
		// Renderiza o formulário de cadastro de estudante
		return "cadastrar-estudante";
	}

	@PostMapping
	public String cadastrarEstudante(HttpServletRequest request) {
		// Obtém os dados do formulário
		String matricula = request.getParameter("matricula");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		int anoEgresso = Integer.parseInt(request.getParameter("anoEgresso"));

		// Cria um novo estudante
		Estudante estudante = new Estudante(matricula, nome, email, anoEgresso);

		// Salva o estudante no banco de dados
		estudanteRepository.save(estudante);

		// Redireciona para uma página de confirmação ou outra ação desejada
		return "redirect:/estudante-confirmacao";
	}
}
