package com.ikravchenko.clinica.controllers;

import com.ikravchenko.clinica.models.Medico;
import com.ikravchenko.clinica.models.Especialidad;
import com.ikravchenko.clinica.models.Cargo;
import com.ikravchenko.clinica.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping("/medicos")
    public String listarMedicos(Model model) {
        List<Medico> medicos = medicoRepository.findAll();
        model.addAttribute("medicos", medicos);
        return "medicos";
    }

    @GetMapping("/medicos/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("medico", new Medico());
        model.addAttribute("especialidades", Especialidad.values());
        model.addAttribute("cargos", Cargo.values());
        return "formularioMedico";
    }

    @GetMapping("/medicos/eliminar/{id}")
    public String eliminarMedico(@PathVariable Long id) {
        medicoRepository.deleteById(id);
        return "redirect:/medicos";
    }
    
    @PostMapping("/medicos")
    public String guardarMedico(@ModelAttribute Medico medico) {
        medicoRepository.save(medico);
        return "redirect:/medicos";
    }


} 