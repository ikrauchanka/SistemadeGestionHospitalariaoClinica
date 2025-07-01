package com.ikravchenko.clinica.models;

import jakarta.persistence.*;

@Entity
public class Enfermero extends Empleado {

    @Enumerated(EnumType.STRING)
    private Area area;

    @Enumerated(EnumType.STRING)
    private Turno turno;

    public Enfermero() {
        super();
    }

    public Enfermero(String nombre, String apellido, int dni, double salario, Cargo cargo, String fechaContratacion, Turno turno) {
        super(nombre, apellido, dni, salario, cargo, fechaContratacion);
        this.turno = turno;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}