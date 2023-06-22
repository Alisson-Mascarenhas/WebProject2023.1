package br.ucsal.apiHorarioacademico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.ucsal.apiHorarioacademico.model.Disciplina;
import br.ucsal.apiHorarioacademico.model.Professor;
import br.ucsal.apiHorarioacademico.repository.DisciplinaRepository;
import br.ucsal.apiHorarioacademico.repository.ProfessorRepository;

@Controller
@RequestMapping("/quadro_horario_professor")
public class QuadroHorarioProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;
    
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @GetMapping
    public String mostrarFormulario() {
        return "quadroHorarioProfessor";
    }

    @PostMapping
    public String emitirQuadroHorario(@RequestParam("matricula") String matricula, Model model) {
        Professor professor = professorRepository.findByMatricula(matricula);

        if (professor != null) {
            List<Disciplina> disciplinas = disciplinaRepository.findByprofessorResponsavel(professor);

            model.addAttribute("disciplinas", disciplinas);

            return "quadroHorarioProfessor";
        } else {
            return "redirect:/erro";
        }
    }

}
