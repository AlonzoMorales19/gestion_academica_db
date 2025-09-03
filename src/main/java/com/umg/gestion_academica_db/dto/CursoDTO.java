package com.umg.gestion_academica_db.dto;

public class CursoDTO {
    private Integer id;
    private String nombreCurso;
    private Short creditos;
    private Short semestre;
    private String nombrePrerequisito;

    public CursoDTO(Integer id, String nombreCurso, Short creditos, Short semestre, String NombrePrerequisito) {
        this.id = id;
        this.nombreCurso = nombreCurso;
        this.creditos = creditos;
        this.semestre = semestre;
        this.nombrePrerequisito = NombrePrerequisito;
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

    public Short getSemestre() {
        return semestre;
    }

    public String getNombrePrerequisito() {
        return nombrePrerequisito;
    }
}
