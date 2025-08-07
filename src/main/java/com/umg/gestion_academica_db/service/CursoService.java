package com.umg.gestion_academica_db.service;

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
}
