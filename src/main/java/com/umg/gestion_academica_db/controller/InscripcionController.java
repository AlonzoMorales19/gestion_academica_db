package com.umg.gestion_academica_db.controller;

import com.umg.gestion_academica_db.dto.InscripcionDTO;
import com.umg.gestion_academica_db.entities.Inscripcion;
import com.umg.gestion_academica_db.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/inscripciones")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    // Crear
    @PostMapping
    public Inscripcion crearInscripcion(@RequestBody Inscripcion inscripcion) {
        return inscripcionService.crearInscripcion(inscripcion);
    }

    // Obtener todos
    @GetMapping
    public List<Inscripcion> obtenerTodos() {
        return inscripcionService.obtenerTodos();
    }

    // Obtener por id
    @GetMapping("/{id}")
    public ResponseEntity<Inscripcion> obtenerPorId(@PathVariable Integer id) {
        return inscripcionService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<Inscripcion> actualizarInscripcion(@PathVariable Integer id,
            @RequestBody Inscripcion inscripcionDetalles) {
        try {
            Inscripcion actualizado = inscripcionService.actualizarInscripcion(id, inscripcionDetalles);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarInscripcion(@PathVariable Integer id) {
        try {
            inscripcionService.eliminarInscripcion(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Obtener todos como DTO
    @GetMapping("/dto")
    public List<InscripcionDTO> obtenerTodosDTO() {
        return inscripcionService.obtenerTodosDTO();
    }

    // Obtener ID como DTO
    @GetMapping("/dto/{id}")
    public ResponseEntity<InscripcionDTO> obtenerPorIdDTO(@PathVariable Integer id) {
        return inscripcionService.obtenerPorIdDTO(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Filtrar por Estudiante
    @GetMapping("/buscar/estudiante")
    public List<InscripcionDTO> buscarPorEstudiante(@RequestParam(required = false) String carnet) {
        return inscripcionService.filtrarPorEstudianteDTO(carnet);
    }

    // Filtrar por Curso
    @GetMapping("/buscar/curso")
    public List<InscripcionDTO> buscarPorCurso(@RequestParam(required = false) String nombreCurso) {
        return inscripcionService.filtrarPorCursoDTO(nombreCurso);
    }

    // Filtrar por Profesor
    @GetMapping("/buscar/profesor")
    public List<InscripcionDTO> buscarPorProfesor(@RequestParam(required = false) String nombreProfesor) {
        return inscripcionService.filtrarPorProfesorDTO(nombreProfesor);
    }

    // Filtrar por Semestre y Ciclo
    @GetMapping("/buscar/semestre-ciclo")
    public List<InscripcionDTO> buscarPorSemestreYCiclo(@RequestParam Short semestre, @RequestParam Short ciclo) {
        return inscripcionService.filtrarPorSemestreYCicloDTO(semestre, ciclo);
    }
}
