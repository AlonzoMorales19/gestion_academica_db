package com.umg.gestion_academica_db.service;

import com.umg.gestion_academica_db.Reports.*;
import com.umg.gestion_academica_db.repositories.ReportesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReporteService {

    @Autowired
    private ReportesRepository reportesRepository;

    public List<CursosPorProfesorDTO> obtenerCursosPorProfesor() {
        return reportesRepository.contarCursosPorProfesor();
    }

    public List<NotaPromedioCursoDTO> obtenerPromedioPorCurso() {
        return reportesRepository.promedioPorCurso();
    }

    public List<EstudiantesPorCicloDTO> obtenerEstudiantesPorCiclo() {
        return reportesRepository.contarEstudiantesPorCiclo();
    }

    public List<TopCursoPromedioDTO> obtenerTop3CursosPromedio() {
        return reportesRepository.top3CursosPromedio(PageRequest.of(0, 3));
    }
}
