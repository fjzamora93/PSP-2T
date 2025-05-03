package com.unir.servidor;

public class Constelacion {
    private String nombre;
    private String descripcion;

    public Constelacion(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " " + descripcion;
    }
}