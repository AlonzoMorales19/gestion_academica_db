package com.umg.gestion_academica_db.repositories;

import com.umg.gestion_academica_db.entities.Imparticion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ImparticionRepository extends JpaRepository<Imparticion, Integer> {
    List<Imparticion> findByCurso_NombreCurso(String nombreCurso);

    List<Imparticion> findByProfesor_NombreCompleto(String nombreProfesor);

    List<Imparticion> findBySemestreAndCiclo(Short semestre, Short ciclo);
}
