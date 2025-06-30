package com.ikravchenko.clinica.repositories;

import com.ikravchenko.clinica.models.HistorialMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialMedicoRepository extends JpaRepository<HistorialMedico, Long> {
} 