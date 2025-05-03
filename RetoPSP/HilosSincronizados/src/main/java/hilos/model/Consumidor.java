package hilos.model;


import hilos.Buffer;

public class Consumidor extends Thread {
    private Buffer buffer;

    // Constructor
    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }

    /** Consume una vacante del buffer cada 0.5 segundos */
    @Override
    public void run() {
        try {
            int numeroIntento = 0;
            while (numeroIntento < 5) {
                Vacante vacanteConsumido = buffer.consume();
                if (vacanteConsumido != null) {
                    System.out.println("Se postuló la vacante con ID: " + Vacante.getId());
                } else {
                    numeroIntento++;
                    System.out.println("INtento número " + numeroIntento);
                }
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("El hilo consumidor fue interrumpido.");
        }
    }
}