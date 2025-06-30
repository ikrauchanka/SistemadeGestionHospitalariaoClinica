package com.ikravchenko.clinica.models;

import jakarta.persistence.*;

@Entity
@Table(name = "pacientes")
public class Paciente extends Persona {

    @Enumerated(EnumType.STRING)
    @Column
    private GrupoSanguineo grupoSanguineo;
    
    @Column
    private String alergias;
    
    @Column
    private String historialMedico;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "historial_id")
    private HistorialMedico historialMedicoObj;

    public Paciente() {
    }

    public Paciente(String nombre, int dni) {
        super(nombre, dni);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Paciente: " + nombre + " " + apellido);
        System.out.println("DNI: " + dni);
        System.out.println("Grupo Sanguíneo: " + grupoSanguineo);
        System.out.println("Alergias: " + alergias);
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public GrupoSanguineo getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(GrupoSanguineo grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }
    
    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(String historialMedico) {
        this.historialMedico = historialMedico;
    }
    
    public HistorialMedico getHistorialMedicoObj() {
        return historialMedicoObj;
    }

    public void setHistorialMedicoObj(HistorialMedico historialMedicoObj) {
        this.historialMedicoObj = historialMedicoObj;
    }
}