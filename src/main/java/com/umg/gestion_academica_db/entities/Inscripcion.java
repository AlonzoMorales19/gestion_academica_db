package com.umg.gestion_academica_db.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "inscripcion")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscripcion")
    private Integer idInscripcion;

    @ManyToOne
    @JoinColumn(name = "carnet_estudiante", nullable = false)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_imparticion", nullable = false)
    private Imparticion imparticion;

    @Column(name = "nota_final", precision = 3, scale = 1)
    private BigDecimal notaFinal;

    @Column(name = "fecha_evaluacion")
    private LocalDate fechaEvaluacion;

    public Inscripcion() {
    }

    public Inscripcion(Integer idInscripcion, Estudiante estudiante, Imparticion imparticion, BigDecimal notaFinal,
            LocalDate fechaEvaluacion) {
        this.idInscripcion = idInscripcion;
        this.estudiante = estudiante;
        this.imparticion = imparticion;
        this.notaFinal = notaFinal;
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public Integer getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(Integer idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Imparticion getImparticion() {
        return imparticion;
    }

    public void setImparticion(Imparticion imparticion) {
        this.imparticion = imparticion;
    }

    public BigDecimal getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(BigDecimal notaFinal) {
        this.notaFinal = notaFinal;
    }

    public LocalDate getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(LocalDate fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }
}
