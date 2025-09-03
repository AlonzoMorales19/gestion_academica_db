package com.umg.gestion_academica_db.service;

import com.umg.gestion_academica_db.dto.CursoDTO;
import com.umg.gestion_academica_db.entities.Curso;
import com.umg.gestion_academica_db.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso crearCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public List<Curso> obtenerTodos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> obtenerPorId(Integer id) {
        return cursoRepository.findById(id);
    }

    public Curso actualizarCurso(Integer id, Curso cursoDetalles) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado " + id));

        curso.setNombreCurso(cursoDetalles.getNombreCurso());
        curso.setCreditos(cursoDetalles.getCreditos());
        curso.setSemestre(cursoDetalles.getSemestre());
        curso.setCiclo(cursoDetalles.getCiclo());

        return cursoRepository.save(curso);
    }

    public void eliminarCurso(Integer id) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado " + id));

        cursoRepository.delete(curso);
    }

    private CursoDTO convertirACursoDTO(Curso curso) {
        return new CursoDTO(
                curso.getIdCurso(),
                curso.getNombreCurso(),
                curso.getCreditos(),
                curso.getSemestre(),
                (curso.getIdPrerequisito() != null) ? curso.getIdPrerequisito().getNombreCurso() : null);
    }

    public List<CursoDTO> obtenerTodosDTO() {
        return obtenerTodos().stream()
                .map(this::convertirACursoDTO)
                .toList();
    }

    public Optional<CursoDTO> obtenerPorIdDTO(Integer id) {
        return obtenerPorId(id).map(this::convertirACursoDTO);
    }

    public List<Curso> filtrarPorSemestre(Short semestre) {
        if (semestre == null) {
            return obtenerTodos();
        }
        return cursoRepository.findBySemestre(semestre);
    }

    public List<CursoDTO> filtrarPorSemestreDTO(Short semestre) {
        return filtrarPorSemestre(semestre).stream()
                .map(this::convertirACursoDTO)
                .toList();
    }
}
