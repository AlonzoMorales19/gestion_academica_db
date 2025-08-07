package com.umg.gestion_academica_db.service;

import com.umg.gestion_academica_db.entities.Estudiante;
import com.umg.gestion_academica_db.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public Estudiante crearEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public List<Estudiante> obtenerTodos() {
        return estudianteRepository.findAll();
    }

    public Optional<Estudiante> obtenerPorId(String carnet) {
        return estudianteRepository.findById(carnet);
    }

    public Estudiante actualizarEstudiante(String carnet, Estudiante estudianteDetalles) {
        Estudiante estudiante = estudianteRepository.findById(carnet)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con carnet " + carnet));

        estudiante.setNombre(estudianteDetalles.getNombre());
        estudiante.setApellido(estudianteDetalles.getApellido());
        estudiante.setFechaNacimiento(estudianteDetalles.getFechaNacimiento());

        return estudianteRepository.save(estudiante);
    }

    public void eliminarEstudiante(String carnet) {
        Estudiante estudiante = estudianteRepository.findById(carnet)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con carnet " + carnet));

        estudianteRepository.delete(estudiante);
    }
}
