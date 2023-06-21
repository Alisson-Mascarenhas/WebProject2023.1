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
        return "quadro-horario-estudante";
    }

    @PostMapping
    public String emitirQuadroHorario(@RequestParam("matricula") String matricula, Model model) {
        
    	Estudante estudante = estudanteRepository.findByMatricula(matricula);

        if (estudante != null) {
            // Obtém os quadros de horários do estudante
            List<QuadroHorario> quadroHorarios = estudante.getQuadroHorarios();

            // Adiciona os dados do quadro de horário ao objeto 'model'
            model.addAttribute("quadroHorarios", quadroHorarios);

            // Retorne o nome da página HTML de exibição do quadro de horário
            return "quadro-horario-estudante";
        } else {
            // Caso o estudante não seja encontrado, pode-se redirecionar para uma página de erro
            return "redirect:/erro";
        }
    }

}
