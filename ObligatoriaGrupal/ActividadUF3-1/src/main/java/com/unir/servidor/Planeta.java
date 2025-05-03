package com.unir.servidor;

public class Planeta {

    private String nombre;
    private double tamaño;
    private double distanciaAlSol;

    public Planeta(String nombre, double tamaño, double distanciaAlSol) {
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.distanciaAlSol = distanciaAlSol;
    }

    public Planeta() {
    }

    public String getNombre() {
        return nombre;
    }

    public double getTamaño() {
        return tamaño;
    }

    public double getDistanciaAlSol() {
        return distanciaAlSol;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    public void setDistanciaAlSol(double distanciaAlSol) {
        this.distanciaAlSol = distanciaAlSol;
    }

    @Override
    public String toString() {
        return "Planeta{" +
                "nombre='" + nombre + '\'' +
                ", tamaño=" + tamaño +
                ", distanciaAlSol=" + distanciaAlSol +
                '}';
    }
}


