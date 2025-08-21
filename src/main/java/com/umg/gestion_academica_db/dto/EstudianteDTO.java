package com.umg.gestion_academica_db.dto;

public class EstudianteDTO {
    private String carnet;
    private String nombreCompleto;
    private Integer edad;

    public EstudianteDTO(String carnet, String nombre, String apellido, Integer edad) {
        this.carnet = carnet;
        this.nombreCompleto = nombre + " " + apellido;
        this.edad = edad;
    }

    public String getCarnet() {
        return carnet;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public Integer getEdad() {
        return edad;
    }
}
