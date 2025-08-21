package com.umg.gestion_academica_db.service;

import com.umg.gestion_academica_db.dto.ProfesorDTO;
import com.umg.gestion_academica_db.entities.Profesor;
import com.umg.gestion_academica_db.repositories.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    public Profesor crearProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public List<Profesor> obtenerTodos() {
        return profesorRepository.findAll();
    }

    public Optional<Profesor> obtenerPorId(Integer id) {
        return profesorRepository.findById(id);
    }

    public Profesor actualizarProfesor(Integer id, Profesor profesorDetalles) {
        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado " + id));

        profesor.setNombreCompleto(profesorDetalles.getNombreCompleto());
        profesor.setCorreo(profesorDetalles.getCorreo());

        return profesorRepository.save(profesor);
    }

    public void eliminarProfesor(Integer id) {
        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado " + id));

        profesorRepository.delete(profesor);
    }

    private ProfesorDTO convertirAProfesorDTO(Profesor profesor) {
        return new ProfesorDTO(profesor.getIdProfesor(), profesor.getNombreCompleto());
    }

    public List<ProfesorDTO> obtenerTodosDTO() {
        return obtenerTodos().stream()
                .map(this::convertirAProfesorDTO)
                .toList();
    }

    public Optional<ProfesorDTO> obtenerPorIdDTO(Integer id) {
        return obtenerPorId(id).map(this::convertirAProfesorDTO);
    }

    public List<Profesor> filtrarPorNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            return obtenerTodos();
        }
        return profesorRepository.findByNombreCompletoContainingIgnoreCase(nombre);
    }

    public List<ProfesorDTO> filtrarPorNombreDTO(String nombre) {
        return filtrarPorNombre(nombre).stream()
                .map(this::convertirAProfesorDTO)
                .toList();
    }
}
