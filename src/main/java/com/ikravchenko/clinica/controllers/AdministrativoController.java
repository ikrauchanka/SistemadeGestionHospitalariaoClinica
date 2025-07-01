package com.ikravchenko.clinica.controllers;

import com.ikravchenko.clinica.models.*;
import com.ikravchenko.clinica.repositories.AdministrativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdministrativoController {

    @Autowired
    private AdministrativoRepository administrativoRepository;

    @GetMapping("/administrativos")
    public String listarAdministrativos(Model model) {
        List<Administrativo> administrativos = administrativoRepository.findAll();
        model.addAttribute("administrativos", administrativos);
        return "administrativos";
    }

    @PostMapping("/administrativos")
    public String guardarAdministrativo(@ModelAttribute Administrativo administrativo) {
        administrativoRepository.save(administrativo);
        return "redirect:/administrativos";
    }

    @GetMapping("/administrativos/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("administrativo", new Administrativo());
        model.addAttribute("areas", Area.values());
        model.addAttribute("cargos", Cargo.values());
        return "formularioAdministrativo";
    }

    @GetMapping("/administrativos/eliminar/{id}")
    public String eliminarAdministrativo(@PathVariable Long id) {
        administrativoRepository.deleteById(id);
        return "redirect:/administrativos";
    }
} 