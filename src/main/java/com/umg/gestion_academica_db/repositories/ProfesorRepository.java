package com.umg.gestion_academica_db.repositories;

import com.umg.gestion_academica_db.entities.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {
    List<Profesor> findByNombreCompletoContainingIgnoreCase(String nombre);
}
