package com.umg.gestion_academica_db.dto;

public class ProfesorDTO {
    private Integer id;
    private String nombreCompleto;

    public ProfesorDTO(Integer id, String nombreCompleto) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
    }

    public Integer getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }
}
