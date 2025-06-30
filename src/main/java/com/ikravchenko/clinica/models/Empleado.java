package com.ikravchenko.clinica.models;

import jakarta.persistence.*;

@Entity
public class Empleado extends Persona{
    @Column
    private double salario;

    @Enumerated(EnumType.STRING)
    @Column
    private Cargo cargo;

    @Column
    private String fechaContratacion;

    public Empleado() {
    }
    
    public Empleado(String nombre, String apellido, int dni, double salario, Cargo cargo, String fechaContratacion) {
        super(nombre, dni);
        this.apellido = apellido;
        this.salario = salario;
        this.cargo = cargo;
        this.fechaContratacion = fechaContratacion;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Empleado: " + nombre + " " + apellido);
        System.out.println("DNI: " + dni);
        System.out.println("Cargo: " + cargo);
        System.out.println("Salario: $" + salario);
        System.out.println("Fecha de contratación: " + fechaContratacion);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }
}
