package hilos;

import hilos.model.Vacante;

public class Productor extends Thread {
    private Buffer buffer;
    private int contadorId;
    private static int idProductor;

    // Constructor
    public Productor(Buffer buffer) {
        this.buffer = buffer;
        this.contadorId = 1;
        idProductor++;
    }

    /** Introduce un mail en el buffer cada 0.5 segundos */
    @Override
    public void run() {
        try {
            while (this.contadorId <= 10) {
                this.contadorId ++;
                Vacante nuevoVacante = new Vacante(
                        "Nº de la vacante: " + contadorId,
                        "Esta es la vacante para el puesto nº"+ this.idProductor*7 ,
                        "0" + contadorId + "/05/2025",
                        "Para la empresa Nº: " + contadorId*3
                );
                buffer.produce(nuevoVacante);
                // Simular la espera de 0.5 segundos
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrumpido el hilo productor");
        }
    }
}
