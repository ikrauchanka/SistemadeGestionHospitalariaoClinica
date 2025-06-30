package com.ikravchenko.clinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ikravchenko.clinica.models.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
