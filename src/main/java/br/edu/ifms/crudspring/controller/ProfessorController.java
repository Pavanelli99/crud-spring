package br.edu.ifms.crudspring.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifms.crudspring.model.Professor;
import br.edu.ifms.crudspring.services.ProfessorService;

public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    @PostMapping("/listar")
    public String saves(@ModelAttribute("professor") Professor professor) {
        professorService.save(professor);
        return "redirect:/professor/listar";
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------

    @GetMapping("/listar")
    public String locall(@Valid Professor professor, Model model) {
        List<Professor> professors = professorService.getProfessores();
        model.addAttribute("listprofessores", professors);
        model.addAttribute("professorUpdate", new Professor());
        return "list-professor";
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------

    @GetMapping("/cadastrar")
    public String Cadastrar(Model model) {
        model.addAttribute("professor", new Professor());
        return "cad-professor";
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------

    @GetMapping("/remove/{id}")
    public String removeProfessor(@PathVariable("id") UUID id) {
        professorService.delete(id);
        return "redirect:/professor/listar";
    }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------
    @PostMapping("/update/{id}")
    public String updateProfessor(@PathVariable("id") UUID id, @Valid Professor professor, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            professor.setId(id);
            return "edit";
        }

        this.professorService.save(professor);

        return "redirect:/professor/listar";
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------

}
