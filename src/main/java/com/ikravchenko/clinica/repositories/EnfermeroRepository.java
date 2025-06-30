package com.ikravchenko.clinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ikravchenko.clinica.models.Enfermero;

public interface EnfermeroRepository extends JpaRepository<Enfermero, Long> {
} 