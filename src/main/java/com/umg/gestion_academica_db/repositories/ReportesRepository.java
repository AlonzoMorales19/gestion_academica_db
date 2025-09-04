package com.umg.gestion_academica_db.repositories;

import com.umg.gestion_academica_db.Reports.*;
import com.umg.gestion_academica_db.entities.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReportesRepository extends JpaRepository<Inscripcion, Integer> {

        // Reporte 1: Total de cursos que imparte cada profesor
        @Query("SELECT NEW com.umg.gestion_academica_db.Reports.CursosPorProfesorDTO(i.profesor.nombreCompleto, COUNT(i.curso)) "
                        +
                        "FROM Imparticion i GROUP BY i.profesor.nombreCompleto")
        List<CursosPorProfesorDTO> contarCursosPorProfesor();

        // Reporte 2: Nota promedio para cada curso
        @Query("SELECT NEW com.umg.gestion_academica_db.Reports.NotaPromedioCursoDTO(i.curso.nombreCurso, AVG(ins.notaFinal)) "
                        +
                        "FROM Inscripcion ins JOIN ins.imparticion i GROUP BY i.curso.nombreCurso")
        List<NotaPromedioCursoDTO> promedioPorCurso();

        // Reporte 3: Estudiantes inscritos por cada ciclo académico
        @Query("SELECT NEW com.umg.gestion_academica_db.Reports.EstudiantesPorCicloDTO(i.ciclo, COUNT(ins)) " +
                        "FROM Inscripcion ins JOIN ins.imparticion i GROUP BY i.ciclo")
        List<EstudiantesPorCicloDTO> contarEstudiantesPorCiclo();

        // Reporte 4: Los 3 cursos con la nota promedio más alta
        @Query("SELECT NEW com.umg.gestion_academica_db.Reports.TopCursoPromedioDTO(i.curso.nombreCurso, AVG(ins.notaFinal)) "
                        +
                        "FROM Inscripcion ins JOIN ins.imparticion i GROUP BY i.curso.nombreCurso " +
                        "ORDER BY AVG(ins.notaFinal) DESC")
        List<TopCursoPromedioDTO> top3CursosPromedio(Pageable pageable);
}
