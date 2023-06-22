package br.ucsal.apiHorarioacademico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.ucsal.apiHorarioacademico.model.Estudante;
import br.ucsal.apiHorarioacademico.model.QuadroHorario;
import br.ucsal.apiHorarioacademico.repository.EstudanteRepository;

@Controller
@RequestMapping("/quadro-horario-estudante")
public class QuadroHorarioEstudanteController {

    @Autowired
    private EstudanteRepository estudanteRepository;

    @GetMapping
    public String mostrarFormulario() {
        return "quadroHorarioEstudante";
    }

    @PostMapping
    public String emitirQuadroHorario(@RequestParam("matricula") String matricula, Model model) {
        
    	Estudante estudante = estudanteRepository.findByMatricula(matricula);

        if (estudante != null) {
            List<QuadroHorario> quadroHorarios = estudante.getQuadroHorarios();

            model.addAttribute("quadroHorarios", quadroHorarios);

            return "quadroHorarioEstudante";
        } else {
            return "redirect:/erro";
        }
    }

}
