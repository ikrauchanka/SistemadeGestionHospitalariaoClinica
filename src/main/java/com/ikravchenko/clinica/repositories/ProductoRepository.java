package com.ikravchenko.clinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ikravchenko.clinica.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
