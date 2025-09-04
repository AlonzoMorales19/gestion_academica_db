package com.umg.gestion_academica_db.dto;

public class ImparticionDTO {
    private Integer id;
    private String nombreCurso;
    private Short creditos;
    private String nombreProfesor;
    private Short semestre;
    private Short ciclo;

    public ImparticionDTO(Integer id, String nombreCurso, Short creditos, String nombreProfesor, Short semestre,
            Short ciclo) {
        this.id = id;
        this.nombreCurso = nombreCurso;
        this.creditos = creditos;
        this.nombreProfesor = nombreProfesor;
        this.semestre = semestre;
        this.ciclo = ciclo;
    }

    public Integer getId() {
        return id;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public Short getCreditos() {
        return creditos;
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
}
