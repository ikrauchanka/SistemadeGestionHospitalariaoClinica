package com.ikravchenko.clinica.controllers;

import com.ikravchenko.clinica.models.*;
import com.ikravchenko.clinica.repositories.PacienteRepository;
import com.ikravchenko.clinica.repositories.HistorialMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;
    
    @Autowired
    private HistorialMedicoRepository historialMedicoRepository;

    @GetMapping("/pacientes")
    public String listarPacientes(Model model) {
        List<Paciente> pacientes = pacienteRepository.findAll();
        model.addAttribute("pacientes", pacientes);
        return "pacientes"; 
    }

    @GetMapping("/pacientes/nuevo")
    public String mostrarFormulario(Model model) {
        Paciente paciente = new Paciente();
        
        StringBuilder alergiasPorDefecto = new StringBuilder();
        Alergia[] alergias = Alergia.values();
        for (int i = 0; i < alergias.length; i++) {
            if (i > 0) {
                alergiasPorDefecto.append(", ");
            }
            alergiasPorDefecto.append(alergias[i].name());
        }
        paciente.setAlergias(alergiasPorDefecto.toString());
        model.addAttribute("paciente", paciente);
        model.addAttribute("grupos", GrupoSanguineo.values());
        return "formularioPaciente";
    }

    @PostMapping("/pacientes")
    public String guardarPaciente(@ModelAttribute Paciente paciente) {
        // Save patient first
        pacienteRepository.save(paciente);

        // Create and save medical history, referencing the already saved patient
        HistorialMedico historial = new HistorialMedico(paciente);
        historialMedicoRepository.save(historial);

        // Link history to patient and save again
        paciente.setHistorialMedicoObj(historial);
        pacienteRepository.save(paciente);

        return "redirect:/pacientes";
    }

    @GetMapping("/pacientes/eliminar/{id}")
    public String eliminarPaciente(@PathVariable Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        paciente.setActivo(false);
        pacienteRepository.save(paciente);
        return "redirect:/pacientes";
    }
    
    @GetMapping("/pacientes/activar/{id}")
    public String activarPaciente(@PathVariable Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        paciente.setActivo(true);
        pacienteRepository.save(paciente);
        return "redirect:/pacientes";
    }
}