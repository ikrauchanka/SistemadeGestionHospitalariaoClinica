package com.ikravchenko.clinica.controllers;

import com.ikravchenko.clinica.models.Paciente;
import com.ikravchenko.clinica.models.GrupoSanguineo;
import com.ikravchenko.clinica.models.Alergia;
import com.ikravchenko.clinica.models.HistorialMedico;
import com.ikravchenko.clinica.repositories.PacienteRepository;
import com.ikravchenko.clinica.repositories.HistorialMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

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
        // Значения аллергий из enum через запятую
        String alergiasPorDefecto = Arrays.stream(Alergia.values())
            .map(Enum::name)
            .collect(Collectors.joining(", "));
        paciente.setAlergias(alergiasPorDefecto);
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

    @GetMapping("/pacientes/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Paciente paciente = pacienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        model.addAttribute("paciente", paciente);
        model.addAttribute("grupos", GrupoSanguineo.values());
        return "formularioPaciente";
    }

    @PostMapping("/pacientes/editar/{id}")
    public String actualizarPaciente(@PathVariable Long id, @ModelAttribute Paciente pacienteActualizado) {
        Paciente paciente = pacienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        paciente.setNombre(pacienteActualizado.getNombre());
        paciente.setApellido(pacienteActualizado.getApellido());
        paciente.setDni(pacienteActualizado.getDni());
        paciente.setGrupoSanguineo(pacienteActualizado.getGrupoSanguineo());
        paciente.setAlergias(pacienteActualizado.getAlergias());
        paciente.setHistorialMedico(pacienteActualizado.getHistorialMedico());
        paciente.setFechaNacimiento(pacienteActualizado.getFechaNacimiento());
        paciente.setDireccion(pacienteActualizado.getDireccion());
        paciente.setTelefono(pacienteActualizado.getTelefono());
        paciente.setEmail(pacienteActualizado.getEmail());

        pacienteRepository.save(paciente);
        return "redirect:/pacientes";
    }
}