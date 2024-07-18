package com.joseflores.examenspring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.joseflores.examenspring.models.ProgramEntity;
import com.joseflores.examenspring.services.ProgramServices;
import com.joseflores.examenspring.services.UserServices;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class ProgramController {
    @Autowired
    private UserServices userServices;
    @Autowired 
    private ProgramServices programServices;

    @GetMapping("/programas")
    public String ProgramaList(Model model) {
    List<ProgramEntity> programas = programServices.findall();
    model.addAttribute("programa", new ProgramEntity());
        return "programaList.jsp";
    }
    @GetMapping("programas/new")
    public String nuevoPrograma(Model model) {
        model.addAttribute("programa", new ProgramEntity());
        return "programaNew.jsp";
    }
    @PostMapping("programas/new")
    public String CrearPrograma(@Valid @ModelAttribute("programa") ProgramEntity programEntity
                            ,BindingResult result , Model model) {
        if (result.hasErrors()) {
            return "programNew.jsp";
        }
        programServices.CrearPrograma(programEntity);
        return "redirect:/programas";
    }
    @GetMapping("/programas/{id}")
    public String programasFindById(@PathVariable("id") Long id, Model model, ProgramEntity programEntity) {
        ProgramEntity showProgramId = programServices.findById(id);
        if (programEntity != null) {
            model.addAttribute("programas", programEntity);
            return "programaList.jsp";
        } else{
        return "redirect:/programas/new";
    }
}
}
