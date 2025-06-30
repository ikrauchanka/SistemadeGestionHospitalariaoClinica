package com.ikravchenko.clinica.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportesController {
    @GetMapping("/reportes")
    public String verReportes() {
        return "reportes";
    }
} 