package br.ucsal.apiHorarioacademico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ucsal.apiHorarioacademico.model.Disciplina;
import br.ucsal.apiHorarioacademico.model.Estudante;
import br.ucsal.apiHorarioacademico.model.QuadroHorario;
import br.ucsal.apiHorarioacademico.repository.DisciplinaRepository;
import br.ucsal.apiHorarioacademico.repository.EstudanteRepository;
import br.ucsal.apiHorarioacademico.repository.QuadroHorarioRepository;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/matricular")
public class MatriculaController {

    private final DisciplinaRepository disciplinaRepository;
    private final EstudanteRepository estudanteRepository;
    private final QuadroHorarioRepository quadroHorarioRepository;

    @Autowired
    public MatriculaController(DisciplinaRepository disciplinaRepository,
                               EstudanteRepository estudanteRepository,
                               QuadroHorarioRepository quadroHorarioRepository) {
        this.disciplinaRepository = disciplinaRepository;
        this.estudanteRepository = estudanteRepository;
        this.quadroHorarioRepository = quadroHorarioRepository;
    }

    @GetMapping
    public String mostrarFormulario(Model model) {
        model.addAttribute("disciplinas", disciplinaRepository.findAll());
        model.addAttribute("estudantes", estudanteRepository.findAll());
        return "matricularEstudante";
    }

    @PostMapping
    public String realizarMatricula(HttpServletRequest request) {
        long disciplinaId = Long.parseLong(request.getParameter("disciplina"));
        long estudanteId = Long.parseLong(request.getParameter("estudante"));

        Disciplina disciplina = disciplinaRepository.findById(disciplinaId).orElse(null);
        Estudante estudante = estudanteRepository.findById(estudanteId).orElse(null);

        if (disciplina != null && estudante != null) {
            QuadroHorario quadroHorario = new QuadroHorario(disciplina, estudante);

            quadroHorarioRepository.save(quadroHorario);
        }

        return "redirect:/matriculaConfirmacao";
    }
}
