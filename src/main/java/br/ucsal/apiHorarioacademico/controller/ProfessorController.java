package br.ucsal.apiHorarioacademico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ucsal.apiHorarioacademico.model.Professor;
import br.ucsal.apiHorarioacademico.repository.ProfessorRepository;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/professor")
public class ProfessorController {

    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorController(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @GetMapping
    public String mostrarFormulario() {
        // Renderiza o formulário de cadastro de professor
        return "cadastrar-professor";
    }

    @PostMapping
    public String cadastrarProfessor(HttpServletRequest request) {
        // Obtém os dados do formulário
        String matricula = request.getParameter("matricula");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        int anoEgresso = Integer.parseInt(request.getParameter("anoEgresso"));

        // Cria um novo professor
        Professor professor = new Professor(matricula, nome, email, anoEgresso);

        // Salva o professor no banco de dados
        professorRepository.save(professor);

        // Redireciona para uma página de confirmação ou outra ação desejada
        return "redirect:/professor-confirmacao";
    }
}