package com.ikravchenko.clinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ikravchenko.clinica.models.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
} 