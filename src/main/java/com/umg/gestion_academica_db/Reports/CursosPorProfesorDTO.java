package com.umg.gestion_academica_db.Reports;

public class CursosPorProfesorDTO {
    private String nombreProfesor;
    private Long totalCursos;

    public CursosPorProfesorDTO(String nombreProfesor, Long totalCursos) {
        this.nombreProfesor = nombreProfesor;
        this.totalCursos = totalCursos;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public Long getTotalCursos() {
        return totalCursos;
    }
}
