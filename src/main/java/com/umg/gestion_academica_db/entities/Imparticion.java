package com.umg.gestion_academica_db.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "imparticion")
public class Imparticion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imparticion")
    private Integer idImparticion;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "id_profesor", nullable = false)
    private Profesor profesor;

    @Column(name = "semestre", nullable = false)
    private Short semestre;

    @Column(name = "ciclo", nullable = false)
    private Short ciclo;

    public Imparticion() {
    }

    public Imparticion(Integer idImparticion, Curso curso, Profesor profesor, Short semestre, Short ciclo) {
        this.idImparticion = idImparticion;
        this.curso = curso;
        this.profesor = profesor;
        this.semestre = semestre;
        this.ciclo = ciclo;
    }

    public Integer getIdImparticion() {
        return idImparticion;
    }

    public void setIdImparticion(Integer idImparticion) {
        this.idImparticion = idImparticion;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
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
