package com.umg.gestion_academica_db.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Integer idCurso;

    @Column(name = "nombre_curso", nullable = false, length = 100)
    private String nombreCurso;

    @Column(name = "creditos", nullable = false)
    private Short creditos;

    @Column(name = "semestre", nullable = false)
    private Short semestre;

    @Column(name = "ciclo", nullable = false)
    private Short ciclo;

    public Curso() {
    }

    public Curso(Integer idCurso, String nombreCurso, Short creditos, Short semestre, Short ciclo) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.creditos = creditos;
        this.semestre = semestre;
        this.ciclo = ciclo;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public Short getCreditos() {
        return creditos;
    }

    public void setCreditos(Short creditos) {
        this.creditos = creditos;
    }

    public Short getSemestre() {
        return semestre;
    }

    public void setSemestre(Short semestre) {
        this.semestre = semestre;
    }

    public Short getCiclo() {
        return ciclo;
    }

    public void setCiclo(Short ciclo) {
        this.ciclo = ciclo;
    }
}
