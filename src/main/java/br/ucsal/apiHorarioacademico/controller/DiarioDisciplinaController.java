package br.ucsal.apiHorarioacademico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ucsal.apiHorarioacademico.model.Disciplina;
import br.ucsal.apiHorarioacademico.repository.DisciplinaRepository;

@Controller
@RequestMapping("/diarioDisciplina")
public class DiarioDisciplinaController {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @GetMapping("/{id}")
    public String emitirDiarioDisciplina(@PathVariable("id") Long id, Model model) {
        Disciplina disciplina = disciplinaRepository.findById(id).orElse(null);

        if (disciplina != null) {
            model.addAttribute("disciplina", disciplina);
            return "diarioDisciplina";
        } else {
            return "redirect:/erro";
        }
    }
}