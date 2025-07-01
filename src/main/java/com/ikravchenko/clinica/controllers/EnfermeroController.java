package com.ikravchenko.clinica.controllers;

import com.ikravchenko.clinica.models.Enfermero;
import com.ikravchenko.clinica.models.Area;
import com.ikravchenko.clinica.models.Turno;
import com.ikravchenko.clinica.models.Cargo;
import com.ikravchenko.clinica.repositories.EnfermeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EnfermeroController {

    @Autowired
    private EnfermeroRepository enfermeroRepository;

    @GetMapping("/enfermeros")
    public String listarEnfermeros(Model model) {
        List<Enfermero> enfermeros = enfermeroRepository.findAll();
        model.addAttribute("enfermeros", enfermeros);
        return "enfermeros";
    }

    @GetMapping("/enfermeros/eliminar/{id}")
    public String eliminarEnfermero(@PathVariable Long id) {
        enfermeroRepository.deleteById(id);
        return "redirect:/enfermeros";
    }
    
    @GetMapping("/enfermeros/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("enfermero", new Enfermero());
        model.addAttribute("areas", Area.values());
        model.addAttribute("turnos", Turno.values());
        model.addAttribute("cargos", Cargo.values());
        return "formularioEnfermero";
    }

    @PostMapping("/enfermeros")
    public String guardarEnfermero(@ModelAttribute Enfermero enfermero) {
        enfermeroRepository.save(enfermero);
        return "redirect:/enfermeros";
    }


} 