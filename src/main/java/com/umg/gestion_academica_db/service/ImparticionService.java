package com.umg.gestion_academica_db.service;

import com.umg.gestion_academica_db.dto.ImparticionDTO;
import com.umg.gestion_academica_db.entities.Imparticion;
import com.umg.gestion_academica_db.repositories.ImparticionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ImparticionService {

    @Autowired
    private ImparticionRepository imparticionRepository;

    public Imparticion crearImparticion(Imparticion imparticion) {
        return imparticionRepository.save(imparticion);
    }

    public List<Imparticion> obtenerTodos() {
        return imparticionRepository.findAll();
    }

    public Optional<Imparticion> obtenerPorId(Integer id) {
        return imparticionRepository.findById(id);
    }

    public Imparticion actualizarImparticion(Integer id, Imparticion imparticionDetalles) {
        Imparticion imparticion = imparticionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Imparticion no encontrada " + id));

        imparticion.setCurso(imparticionDetalles.getCurso());
        imparticion.setProfesor(imparticionDetalles.getProfesor());
        imparticion.setSemestre(imparticionDetalles.getSemestre());
        imparticion.setCiclo(imparticionDetalles.getCiclo());

        return imparticionRepository.save(imparticion);
    }

    public void eliminarImparticion(Integer id) {
        Imparticion imparticion = imparticionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Imparticion no encontrada " + id));

        imparticionRepository.delete(imparticion);
    }

    private ImparticionDTO convertirAImparticionDTO(Imparticion imparticion) {
        return new ImparticionDTO(
                imparticion.getIdImparticion(),
                imparticion.getCurso().getNombreCurso(),
                imparticion.getCurso().getCreditos(),
                imparticion.getProfesor().getNombreCompleto(),
                imparticion.getSemestre(),
                imparticion.getCiclo());
    }

    public List<ImparticionDTO> obtenerTodosDTO() {
        return obtenerTodos().stream()
                .map(this::convertirAImparticionDTO)
                .toList();
    }

    public Optional<ImparticionDTO> obtenerPorIdDTO(Integer id) {
        return obtenerPorId(id).map(this::convertirAImparticionDTO);
    }

    public List<Imparticion> filtrarPorCurso(String nombreCurso) {
        if (nombreCurso == null || nombreCurso.isBlank()) {
            return obtenerTodos();
        }
        return imparticionRepository.findByCurso_NombreCurso(nombreCurso);
    }

    public List<ImparticionDTO> filtrarPorCursoDTO(String nombreCurso) {
        return filtrarPorCurso(nombreCurso).stream()
                .map(this::convertirAImparticionDTO)
                .toList();
    }

    public List<Imparticion> filtrarPorProfesor(String nombreProfesor) {
        if (nombreProfesor == null || nombreProfesor.isBlank()) {
            return obtenerTodos();
        }
        return imparticionRepository.findByProfesor_NombreCompleto(nombreProfesor);
    }

    public List<ImparticionDTO> filtrarPorProfesorDTO(String nombreProfesor) {
        return filtrarPorProfesor(nombreProfesor).stream()
                .map(this::convertirAImparticionDTO)
                .toList();
    }

    public List<Imparticion> filtrarPorSemestreYCiclo(Short semestre, Short ciclo) {
        if (semestre == null || ciclo == null) {
            return obtenerTodos();
        }
        return imparticionRepository.findBySemestreAndCiclo(semestre, ciclo);
    }

    public List<ImparticionDTO> filtrarPorSemestreYCicloDTO(Short semestre, Short ciclo) {
        return filtrarPorSemestreYCiclo(semestre, ciclo).stream()
                .map(this::convertirAImparticionDTO)
                .toList();
    }
}
