package com.umg.gestion_academica_db.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InscripcionDTO {
    private Integer id;
    private String carnetEstudiante;
    private String nombreCompletoEstudiante;
    private String nombreCurso;
    private String nombreProfesor;
    private Short semestre;
    private Short ciclo;
    private BigDecimal notaFinal;
    private LocalDate fechaEvaluacion;

    public InscripcionDTO(Integer id, String carnetEstudiante, String nombreCompletoEstudiante, String nombreCurso,
            String nombreProfesor, Short semestre, Short ciclo, BigDecimal notaFinal, LocalDate fechaEvaluacion) {
        this.id = id;
        this.carnetEstudiante = carnetEstudiante;
        this.nombreCompletoEstudiante = nombreCompletoEstudiante;
        this.nombreCurso = nombreCurso;
        this.nombreProfesor = nombreProfesor;
        this.semestre = semestre;
        this.ciclo = ciclo;
        this.notaFinal = notaFinal;
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public Integer getId() {
        return id;
    }

    public String getCarnetEstudiante() {
        return carnetEstudiante;
    }

    public String getNombreCompletoEstudiante() {
        return nombreCompletoEstudiante;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public Short getSemestre() {
        return semestre;
    }

    public Short getCiclo() {
        return ciclo;
    }

    public BigDecimal getNotaFinal() {
        return notaFinal;
    }

    public LocalDate getFechaEvaluacion() {
        return fechaEvaluacion;
    }
}
