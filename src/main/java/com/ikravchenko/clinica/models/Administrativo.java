package com.ikravchenko.clinica.models;

import jakarta.persistence.*;

@Entity
public class Administrativo extends Empleado {
    @Enumerated(EnumType.STRING)
    private Area area;

    public Administrativo() {}

    public Administrativo(String nombre, String apellido, int dni, double salario, Cargo cargo, String fechaContratacion, Area area) {
        super(nombre, apellido, dni, salario, cargo, fechaContratacion);
        this.area = area;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Administrativo: " + nombre + " " + apellido);
        System.out.println("DNI: " + dni);
        System.out.println("Cargo: " + getCargo());
        System.out.println("Area: " + area);
    }
}