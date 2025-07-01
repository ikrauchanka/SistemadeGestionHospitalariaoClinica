package com.ikravchenko.clinica.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "historial_medico")
public class HistorialMedico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistorial;
    
    @OneToOne(mappedBy = "historialMedicoObj")
    private Paciente paciente;
    
    @ElementCollection
    @CollectionTable(name = "historial_diagnosticos", joinColumns = @JoinColumn(name = "historial_id"))
    @Column(name = "diagnostico")
    private List<String> diagnosticos = new ArrayList<>();
    
    @ElementCollection
    @CollectionTable(name = "historial_tratamientos", joinColumns = @JoinColumn(name = "historial_id"))
    @Column(name = "tratamiento")
    private List<String> tratamientos = new ArrayList<>();
    
    @OneToMany(mappedBy = "historialMedico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Consulta> consultas = new ArrayList<>();

    public HistorialMedico() {}

    public HistorialMedico(Paciente paciente) {
        this.paciente = paciente;
    }

    public void agregarDiagnostico(String diagnostico) {
        this.diagnosticos.add(diagnostico);
    }

    public void agregarTratamiento(String tratamiento) {
        this.tratamientos.add(tratamiento);
    }

    public void agregarConsulta(Consulta consulta) {
        this.consultas.add(consulta);
        consulta.setHistorialMedico(this);
    }

    // Getters y Setters
    public Long getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(Long idHistorial) {
        this.idHistorial = idHistorial;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<String> getDiagnosticos() {
        return diagnosticos;
    }

    public void setDiagnosticos(List<String> diagnosticos) {
        this.diagnosticos = diagnosticos;
    }

    public List<String> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<String> tratamientos) {
        this.tratamientos = tratamientos;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
} 