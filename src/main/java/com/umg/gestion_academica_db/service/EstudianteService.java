package com.umg.gestion_academica_db.service;

import com.umg.gestion_academica_db.dto.EstudianteDTO;
import com.umg.gestion_academica_db.entities.Estudiante;
import com.umg.gestion_academica_db.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado " + carnet));

        estudiante.setNombre(estudianteDetalles.getNombre());
        estudiante.setApellido(estudianteDetalles.getApellido());
        estudiante.setFechaNacimiento(estudianteDetalles.getFechaNacimiento());

        return estudianteRepository.save(estudiante);
    }

    public void eliminarEstudiante(String carnet) {
        Estudiante estudiante = estudianteRepository.findById(carnet)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado " + carnet));

        estudianteRepository.delete(estudiante);
    }

    private EstudianteDTO convertirAEstudianteDTO(Estudiante estudiante) {
        int edad = LocalDate.now().getYear() - estudiante.getFechaNacimiento().getYear();
        return new EstudianteDTO(
                estudiante.getCarnet(),
                estudiante.getNombre(),
                estudiante.getApellido(),
                edad);
    }

    public List<EstudianteDTO> obtenerTodosDTO() {
        return obtenerTodos().stream()
                .map(this::convertirAEstudianteDTO)
                .toList();
    }

    public Optional<EstudianteDTO> obtenerPorIdDTO(String carnet) {
        return obtenerPorId(carnet).map(this::convertirAEstudianteDTO);
    }

    public List<Estudiante> filtrarPorApellido(String apellido) {
        if (apellido == null || apellido.isBlank()) {
            return obtenerTodos();
        }
        return estudianteRepository.findByApellidoContainingIgnoreCase(apellido);
    }

    public List<EstudianteDTO> filtrarPorApellidoDTO(String apellido) {
        return filtrarPorApellido(apellido).stream()
                .map(this::convertirAEstudianteDTO)
                .toList();
    }
}
