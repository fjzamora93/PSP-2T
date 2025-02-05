package com.unir.servidor;

public class Estrella {
    private String nombre;
    private String descripcion;

    public Estrella(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return nombre + " " + descripcion;
    }
}