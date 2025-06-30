package com.ikravchenko.clinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ikravchenko.clinica.models.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
} 