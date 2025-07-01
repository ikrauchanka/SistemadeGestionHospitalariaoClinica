package com.ikravchenko.clinica.controllers;

import com.ikravchenko.clinica.models.Medico;
import com.ikravchenko.clinica.models.Especialidad;
import com.ikravchenko.clinica.models.Cargo;
import com.ikravchenko.clinica.models.Consulta;
import com.ikravchenko.clinica.repositories.MedicoRepository;
import com.ikravchenko.clinica.repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;
    
    @Autowired
    private ConsultaRepository consultaRepository;

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
    public String eliminarMedico(@PathVariable Long id, Model model) {
        try {
            // First, try to find the doctor
            Medico medico = medicoRepository.findById(id).orElse(null);
            if (medico == null) {
                model.addAttribute("error", "Médico no encontrado.");
                List<Medico> medicos = medicoRepository.findAll();
                model.addAttribute("medicos", medicos);
                return "medicos";
            }
            
            // Check if doctor has appointments using a more direct approach
            long consultaCount = consultaRepository.count();
            List<Consulta> allConsultas = consultaRepository.findAll();
            List<Consulta> doctorConsultas = allConsultas.stream()
                .filter(consulta -> consulta.getMedico() != null && consulta.getMedico().getId().equals(id))
                .toList();
            
            if (!doctorConsultas.isEmpty()) {
                // Cannot delete doctor with appointments
                model.addAttribute("error", "No se puede eliminar el médico porque tiene " + doctorConsultas.size() + " consulta(s) registrada(s). Elimine las consultas primero.");
                List<Medico> medicos = medicoRepository.findAll();
                model.addAttribute("medicos", medicos);
                return "medicos";
            }
            
            // If no appointments, safe to delete
            medicoRepository.deleteById(id);
            return "redirect:/medicos";
            
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el médico: " + e.getMessage());
            List<Medico> medicos = medicoRepository.findAll();
            model.addAttribute("medicos", medicos);
            return "medicos";
        }
    }
    
    @PostMapping("/medicos")
    public String guardarMedico(@ModelAttribute Medico medico) {
        medicoRepository.save(medico);
        return "redirect:/medicos";
    }
} 