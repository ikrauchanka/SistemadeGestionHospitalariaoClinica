package com.ikravchenko.clinica.controllers;

import com.ikravchenko.clinica.models.HistorialMedico;
import com.ikravchenko.clinica.repositories.HistorialMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HistorialMedicoController {

    @Autowired
    private HistorialMedicoRepository historialMedicoRepository;

    @GetMapping("/historiales")
    public String listarHistoriales(Model model) {
        List<HistorialMedico> historiales = historialMedicoRepository.findAll();
        model.addAttribute("historiales", historiales);
        return "historiales";
    }

    @GetMapping("/historiales/{id}")
    public String verHistorial(@PathVariable Long id, Model model) {
        HistorialMedico historial = historialMedicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Historial no encontrado"));
        model.addAttribute("historial", historial);
        return "verHistorial";
    }
} 