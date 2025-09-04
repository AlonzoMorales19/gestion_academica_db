package com.umg.gestion_academica_db.controller;

import com.umg.gestion_academica_db.dto.ImparticionDTO;
import com.umg.gestion_academica_db.entities.Imparticion;
import com.umg.gestion_academica_db.service.ImparticionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/imparticiones")
public class ImparticionController {

    @Autowired
    private ImparticionService imparticionService;

    // Crear
    @PostMapping
    public Imparticion crearImparticion(@RequestBody Imparticion imparticion) {
        return imparticionService.crearImparticion(imparticion);
    }

    // Obtener todos
    @GetMapping
    public List<Imparticion> obtenerTodos() {
        return imparticionService.obtenerTodos();
    }

    // Obtener por id
    @GetMapping("/{id}")
    public ResponseEntity<Imparticion> obtenerPorId(@PathVariable Integer id) {
        return imparticionService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<Imparticion> actualizarImparticion(@PathVariable Integer id,
            @RequestBody Imparticion imparticionDetalles) {
        try {
            Imparticion actualizado = imparticionService.actualizarImparticion(id, imparticionDetalles);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarImparticion(@PathVariable Integer id) {
        try {
            imparticionService.eliminarImparticion(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Obtener todos como DTO
    @GetMapping("/dto")
    public List<ImparticionDTO> obtenerTodosDTO() {
        return imparticionService.obtenerTodosDTO();
    }

    // Obtener ID como DTO
    @GetMapping("/dto/{id}")
    public ResponseEntity<ImparticionDTO> obtenerPorIdDTO(@PathVariable Integer id) {
        return imparticionService.obtenerPorIdDTO(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Filtrar por Curso
    @GetMapping("/buscar/curso")
    public List<ImparticionDTO> buscarPorCurso(@RequestParam(required = false) String nombreCurso) {
        return imparticionService.filtrarPorCursoDTO(nombreCurso);
    }

    // Filtrar por Profesor
    @GetMapping("/buscar/profesor")
    public List<ImparticionDTO> buscarPorProfesor(@RequestParam(required = false) String nombreProfesor) {
        return imparticionService.filtrarPorProfesorDTO(nombreProfesor);
    }

    // Filtrar por Semestre y Ciclo
    @GetMapping("/buscar/semestre-ciclo")
    public List<ImparticionDTO> buscarPorSemestreYCiclo(@RequestParam Short semestre, @RequestParam Short ciclo) {
        return imparticionService.filtrarPorSemestreYCicloDTO(semestre, ciclo);
    }
}
