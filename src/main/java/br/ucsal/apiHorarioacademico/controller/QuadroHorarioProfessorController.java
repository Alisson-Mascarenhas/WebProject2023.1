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
        return "quadro-horario-professor";
    }

    @PostMapping
    public String emitirQuadroHorario(@RequestParam("matricula") String matricula, Model model) {
        Professor professor = professorRepository.findByMatricula(matricula);

        if (professor != null) {
            // Lógica para obter o quadro de horário do professor
            List<Disciplina> disciplinas = disciplinaRepository.findByprofessorResponsavel(professor);

            // Adicione os dados do quadro de horário ao objeto 'model'
            model.addAttribute("disciplinas", disciplinas);

            // Retorne o nome da página HTML de exibição do quadro de horário
            return "quadro-horario-professor";
        } else {
            // Caso o professor não seja encontrado, pode-se redirecionar para uma página de erro
            return "redirect:/erro";
        }
    }

}
