package com.ikravchenko.clinica.controllers;

import com.ikravchenko.clinica.models.Empleado;
import com.ikravchenko.clinica.models.Cargo;
import com.ikravchenko.clinica.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpleadoController {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping("/empleados")
    public String listarEmpleados(Model model) {
        List<Empleado> empleados = empleadoRepository.findAll();
        model.addAttribute("empleados", empleados);
        return "empleados";
    }

    @GetMapping("/empleados/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("empleado", new Empleado());
        model.addAttribute("cargos", Cargo.values());
        return "formularioEmpleado";
    }

    @PostMapping("/empleados")
    public String guardarEmpleado(@ModelAttribute Empleado empleado) {
        empleadoRepository.save(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/empleados/eliminar/{id}")
    public String eliminarEmpleado(@PathVariable Long id) {
        empleadoRepository.deleteById(id);
        return "redirect:/empleados";
    }
} 