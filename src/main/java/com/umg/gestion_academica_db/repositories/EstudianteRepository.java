package com.umg.gestion_academica_db.repositories;

import com.umg.gestion_academica_db.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, String> {
    List<Estudiante> findByApellidoContainingIgnoreCase(String apellido);
}
