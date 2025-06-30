package com.ikravchenko.clinica.controllers;

import com.ikravchenko.clinica.models.Consulta;
import com.ikravchenko.clinica.models.Medico;
import com.ikravchenko.clinica.models.Paciente;
import com.ikravchenko.clinica.repositories.ConsultaRepository;
import com.ikravchenko.clinica.repositories.MedicoRepository;
import com.ikravchenko.clinica.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;
    
    @Autowired
    private MedicoRepository medicoRepository;
    
    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping("/consultas")
    public String listarConsultas(Model model) {
        List<Consulta> consultas = consultaRepository.findAll();
        model.addAttribute("consultas", consultas);
        return "consultas";
    }

    @GetMapping("/consultas/nueva")
    public String mostrarFormulario(Model model) {
        List<Medico> medicos = medicoRepository.findAll();
        List<Paciente> pacientes = pacienteRepository.findAll();
        
        model.addAttribute("consulta", new Consulta());
        model.addAttribute("medicos", medicos);
        model.addAttribute("pacientes", pacientes);
        return "formularioConsulta";
    }

    @PostMapping("/consultas")
    public String guardarConsulta(@ModelAttribute Consulta consulta, 
                                 @RequestParam Long medicoId,
                                 @RequestParam Long pacienteId) {
        Medico medico = medicoRepository.findById(medicoId)
                .orElseThrow(() -> new RuntimeException("Médico no encontrado"));
        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        
        consulta.setMedico(medico);
        consulta.setPaciente(paciente);
        
        consultaRepository.save(consulta);
        return "redirect:/consultas";
    }

    @GetMapping("/consultas/{id}")
    public String verConsulta(@PathVariable Long id, Model model) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta no encontrada"));
        model.addAttribute("consulta", consulta);
        return "verConsulta";
    }

    @GetMapping("/consultas/eliminar/{id}")
    public String eliminarConsulta(@PathVariable Long id) {
        consultaRepository.deleteById(id);
        return "redirect:/consultas";
    }
} 