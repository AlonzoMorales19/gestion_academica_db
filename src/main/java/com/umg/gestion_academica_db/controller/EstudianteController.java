package com.umg.gestion_academica_db.controller;

import com.umg.gestion_academica_db.entities.Estudiante;
import com.umg.gestion_academica_db.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    // Crear
    @PostMapping
    public Estudiante crearEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteService.crearEstudiante(estudiante);
    }

    // Obtener todos
    @GetMapping
    public List<Estudiante> obtenerTodos() {
        return estudianteService.obtenerTodos();
    }

    // Obtener por id
    @GetMapping("/{carnet}")
    public ResponseEntity<Estudiante> obtenerPorId(@PathVariable String carnet) {
        return estudianteService.obtenerPorId(carnet)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar
    @PutMapping("/{carnet}")
    public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable String carnet,
            @RequestBody Estudiante estudianteDetalles) {
        try {
            Estudiante actualizado = estudianteService.actualizarEstudiante(carnet, estudianteDetalles);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar
    @DeleteMapping("/{carnet}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable String carnet) {
        try {
            estudianteService.eliminarEstudiante(carnet);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
