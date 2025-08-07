package com.umg.gestion_academica_db.service;

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
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado con id " + id));

        profesor.setNombreCompleto(profesorDetalles.getNombreCompleto());
        profesor.setCorreo(profesorDetalles.getCorreo());

        return profesorRepository.save(profesor);
    }

    public void eliminarProfesor(Integer id) {
        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado con id " + id));

        profesorRepository.delete(profesor);
    }
}
