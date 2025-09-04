package com.umg.gestion_academica_db.Reports;

public class TopCursoPromedioDTO {
    private String nombreCurso;
    private Double notaPromedio;

    public TopCursoPromedioDTO(String nombreCurso, Double notaPromedio) {
        this.nombreCurso = nombreCurso;
        this.notaPromedio = notaPromedio;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public Double getNotaPromedio() {
        return notaPromedio;
    }
}
