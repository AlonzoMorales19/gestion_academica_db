package com.umg.gestion_academica_db.Reports;

public class EstudiantesPorCicloDTO {
    private Short ciclo;
    private Long totalEstudiantes;

    public EstudiantesPorCicloDTO(Short ciclo, Long totalEstudiantes) {
        this.ciclo = ciclo;
        this.totalEstudiantes = totalEstudiantes;
    }

    public Short getCiclo() {
        return ciclo;
    }

    public Long getTotalEstudiantes() {
        return totalEstudiantes;
    }
}
