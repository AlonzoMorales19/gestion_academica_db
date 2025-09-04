package com.umg.gestion_academica_db.controller;

import com.umg.gestion_academica_db.Reports.*;
import com.umg.gestion_academica_db.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    // Reporte 1: Total de cursos que imparte cada profesor
    @GetMapping("/cursosProfesor")
    public List<CursosPorProfesorDTO> cursosPorProfesor() {
        return reporteService.obtenerCursosPorProfesor();
    }

    // Reporte 2: Nota promedio para cada curso
    @GetMapping("/promedioCurso")
    public List<NotaPromedioCursoDTO> promedioPorCurso() {
        return reporteService.obtenerPromedioPorCurso();
    }

    // Reporte 3: Estudiantes inscritos por cada ciclo académico
    @GetMapping("/estudiantesCiclo")
    public List<EstudiantesPorCicloDTO> estudiantesPorCiclo() {
        return reporteService.obtenerEstudiantesPorCiclo();
    }

    // Reporte 4: Los 3 cursos con la nota promedio más alta
    @GetMapping("/top3Cursos")
    public List<TopCursoPromedioDTO> top3Cursos() {
        return reporteService.obtenerTop3CursosPromedio();
    }
}
