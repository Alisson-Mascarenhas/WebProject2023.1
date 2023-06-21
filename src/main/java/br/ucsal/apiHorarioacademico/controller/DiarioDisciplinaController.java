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
import br.ucsal.apiHorarioacademico.model.QuadroHorario;
import br.ucsal.apiHorarioacademico.repository.DisciplinaRepository;

@Controller
@RequestMapping("/diario_disciplina")
public class DiarioDisciplinaController {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @GetMapping
    public String mostrarFormulario() {
        return "diario-disciplina";
    }

    @PostMapping
    public String emitirDiarioDisciplina(@RequestParam("codigo") String codigo, Model model) {
        
    	Disciplina disciplina = disciplinaRepository.findByCodigo(codigo);

        if (disciplina != null) {
            // Obtém os dados da disciplina
            String nomeDisciplina = disciplina.getNome();
            String diaHorario = disciplina.getDiaHorario().toString();
            Professor professor = disciplina.getProfessorResponsavel();
            List<QuadroHorario> quadroEstudantes = disciplina.getQuadroHorarios();

            // Adiciona os dados ao objeto 'model'
            model.addAttribute("nomeDisciplina", nomeDisciplina);
            model.addAttribute("diaHorario", diaHorario);
            model.addAttribute("professor", professor);
            model.addAttribute("quadroEstudantes", quadroEstudantes);

            // Retorne o nome da página HTML de exibição do diário da disciplina
            return "diario-disciplina";
        } else {
            // Caso a disciplina não seja encontrada, pode-se redirecionar para uma página de erro
            return "redirect:/erro";
        }
    }
}
