package com.umg.gestion_academica_db.repositories;

import com.umg.gestion_academica_db.entities.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Integer> {
        List<Inscripcion> findByEstudiante_Carnet(String carnet);

        List<Inscripcion> findByImparticion_Curso_NombreCurso(String nombreCurso);

        List<Inscripcion> findByImparticion_Profesor_NombreCompleto(String nombreProfesor);

        List<Inscripcion> findByImparticion_SemestreAndImparticion_Ciclo(Short semestre, Short ciclo);
}
