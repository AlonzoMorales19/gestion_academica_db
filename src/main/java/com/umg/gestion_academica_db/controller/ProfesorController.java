package com.umg.gestion_academica_db.controller;

import com.umg.gestion_academica_db.entities.Profesor;
import com.umg.gestion_academica_db.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    // Crear
    @PostMapping
    public Profesor crearProfesor(@RequestBody Profesor profesor) {
        return profesorService.crearProfesor(profesor);
    }

    // Obtener todos
    @GetMapping
    public List<Profesor> obtenerTodos() {
        return profesorService.obtenerTodos();
    }

    // Obtener por id
    @GetMapping("/{id}")
    public ResponseEntity<Profesor> obtenerPorId(@PathVariable Integer id) {
        return profesorService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<Profesor> actualizarProfesor(@PathVariable Integer id,
            @RequestBody Profesor profesorDetalles) {
        try {
            Profesor actualizado = profesorService.actualizarProfesor(id, profesorDetalles);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProfesor(@PathVariable Integer id) {
        try {
            profesorService.eliminarProfesor(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
