package com.umg.gestion_academica_db.service;

import com.umg.gestion_academica_db.dto.InscripcionDTO;
import com.umg.gestion_academica_db.entities.Inscripcion;
import com.umg.gestion_academica_db.repositories.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    public Inscripcion crearInscripcion(Inscripcion inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }

    public List<Inscripcion> obtenerTodos() {
        return inscripcionRepository.findAll();
    }

    public Optional<Inscripcion> obtenerPorId(Integer id) {
        return inscripcionRepository.findById(id);
    }

    public Inscripcion actualizarInscripcion(Integer id, Inscripcion inscripcionDetalles) {
        Inscripcion inscripcion = inscripcionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscripcion no encontrada " + id));

        inscripcion.setEstudiante(inscripcionDetalles.getEstudiante());
        inscripcion.setImparticion(inscripcionDetalles.getImparticion());
        inscripcion.setNotaFinal(inscripcionDetalles.getNotaFinal());
        inscripcion.setFechaEvaluacion(inscripcionDetalles.getFechaEvaluacion());

        return inscripcionRepository.save(inscripcion);
    }

    public void eliminarInscripcion(Integer id) {
        Inscripcion inscripcion = inscripcionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscripcion no encontrada " + id));

        inscripcionRepository.delete(inscripcion);
    }

    private InscripcionDTO convertirAInscripcionDTO(Inscripcion inscripcion) {
        return new InscripcionDTO(
                inscripcion.getIdInscripcion(),
                inscripcion.getEstudiante().getCarnet(),
                inscripcion.getEstudiante().getNombre() + " " + inscripcion.getEstudiante().getApellido(),
                inscripcion.getImparticion().getCurso().getNombreCurso(),
                inscripcion.getImparticion().getProfesor().getNombreCompleto(),
                inscripcion.getImparticion().getSemestre(),
                inscripcion.getImparticion().getCiclo(),
                inscripcion.getNotaFinal(),
                inscripcion.getFechaEvaluacion());
    }

    public List<InscripcionDTO> obtenerTodosDTO() {
        return obtenerTodos().stream()
                .map(this::convertirAInscripcionDTO)
                .toList();
    }

    public Optional<InscripcionDTO> obtenerPorIdDTO(Integer id) {
        return obtenerPorId(id).map(this::convertirAInscripcionDTO);
    }

    public List<Inscripcion> filtrarPorEstudiante(String carnet) {
        if (carnet == null || carnet.isBlank()) {
            return obtenerTodos();
        }
        return inscripcionRepository.findByEstudiante_Carnet(carnet);
    }

    public List<InscripcionDTO> filtrarPorEstudianteDTO(String carnet) {
        return filtrarPorEstudiante(carnet).stream()
                .map(this::convertirAInscripcionDTO)
                .toList();
    }

    public List<Inscripcion> filtrarPorCurso(String nombreCurso) {
        if (nombreCurso == null || nombreCurso.isBlank()) {
            return obtenerTodos();
        }
        return inscripcionRepository.findByImparticion_Curso_NombreCurso(nombreCurso);
    }

    public List<InscripcionDTO> filtrarPorCursoDTO(String nombreCurso) {
        return filtrarPorCurso(nombreCurso).stream()
                .map(this::convertirAInscripcionDTO)
                .toList();
    }

    public List<Inscripcion> filtrarPorProfesor(String nombreProfesor) {
        if (nombreProfesor == null || nombreProfesor.isBlank()) {
            return obtenerTodos();
        }
        return inscripcionRepository.findByImparticion_Profesor_NombreCompleto(nombreProfesor);
    }

    public List<InscripcionDTO> filtrarPorProfesorDTO(String nombreProfesor) {
        return filtrarPorProfesor(nombreProfesor).stream()
                .map(this::convertirAInscripcionDTO)
                .toList();
    }

    public List<Inscripcion> filtrarPorSemestreYCiclo(Short semestre, Short ciclo) {
        if (semestre == null || ciclo == null) {
            return obtenerTodos();
        }
        return inscripcionRepository.findByImparticion_SemestreAndImparticion_Ciclo(semestre, ciclo);
    }

    public List<InscripcionDTO> filtrarPorSemestreYCicloDTO(Short semestre, Short ciclo) {
        return filtrarPorSemestreYCiclo(semestre, ciclo).stream()
                .map(this::convertirAInscripcionDTO)
                .toList();
    }
}
