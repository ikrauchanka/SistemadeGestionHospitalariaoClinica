package com.ikravchenko.clinica.models;

import jakarta.persistence.*;
import java.util.Map;

@Entity
public class Medico extends Empleado {
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    private String numMatricula;
    @ElementCollection
    @CollectionTable(name = "medico_horario", joinColumns = @JoinColumn(name = "medico_id"))
    @MapKeyColumn(name = "dia")
    @Column(name = "horario")
    private Map<String, String> horarioAtencion; // ejemplo: "Lunes" -> "8:00-12:00"

    public Medico() {

    }

    public Medico(String nombre, String apellido, int dni, double salario, Cargo cargo, String fechaContratacion, Especialidad especialidad, String numMatricula, Map<String, String> horarioAtencion) {
        super(nombre, apellido, dni, salario, cargo, fechaContratacion);
        this.especialidad = especialidad;
        this.numMatricula = numMatricula;
        this.horarioAtencion = horarioAtencion;
    }

    // Getters y Setters
    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public String getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(String numMatricula) {
        this.numMatricula = numMatricula;
    }

    public void setHorarioAtencion(Map<String, String> horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
    }

    public Map<String, String> getHorarioAtencion() {
        return horarioAtencion;
    }
}