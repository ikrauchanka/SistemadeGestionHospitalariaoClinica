package com.ikravchenko.clinica.repositories;

import com.ikravchenko.clinica.models.Administrativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrativoRepository extends JpaRepository<Administrativo, Long> {
} 