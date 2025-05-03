package hilos;

import hilos.model.Vacante;

import java.util.LinkedList;

public class Buffer {
    // Atributo para almacenar la lista de mails
    private LinkedList<Vacante> listaVacantes;

    // Constructor
    public Buffer() {
        this.listaVacantes = new LinkedList<>();
    }

    // Método para agregar una vacante a la lista
    public synchronized void produce(Vacante vacante) {
        listaVacantes.add(vacante);
        System.out.println("Aceptando candidaturas para " + vacante.getTittle() + " con fecha " + vacante.getDate());
        notify(); // Despierta a un consumidor esperando
    }

    public synchronized Vacante consume() {
        while (listaVacantes.isEmpty()) {
            try {
                wait(); // Espera a que haya vacantes
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        Vacante vacante = listaVacantes.remove();
        System.out.println("Postulando candidatura para la vacante " + vacante.getTittle() + " de la empresa " + vacante.getCompany());
        return vacante;
    }
}

