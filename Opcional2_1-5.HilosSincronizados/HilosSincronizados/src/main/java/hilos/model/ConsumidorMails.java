package hilos.model;


import hilos.BufferMails;

public class ConsumidorMails extends Thread {
    private BufferMails bufferMails;

    // Constructor
    public ConsumidorMails(BufferMails bufferMails) {
        this.bufferMails = bufferMails;
    }

    /** Consume un mail del buffer cada 0.5 segundos */
    @Override
    public void run() {
        try {
            int numeroIntento = 0;
            while (numeroIntento < 5) {
                Mail mailConsumido = bufferMails.consumirMail();
                if (mailConsumido != null) {
                    System.out.println("Se consumió el mail con ID: " + mailConsumido.getId());
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