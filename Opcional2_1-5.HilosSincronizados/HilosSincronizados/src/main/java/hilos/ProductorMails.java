package hilos;

import hilos.model.Mail;

public class ProductorMails extends Thread {
    private BufferMails bufferMails;
    private int contadorId;
    private static int idProductor;

    // Constructor
    public ProductorMails(BufferMails bufferMails) {
        this.bufferMails = bufferMails;
        this.contadorId = 1;
        idProductor++;
    }


    /** Introduce un mail en el buffer cada 0.5 segundos */
    @Override
    public void run() {
        try {
            while (this.contadorId <= 10) {
                this.contadorId ++;
                Mail nuevoMail = new Mail(
                        "destinatario" + contadorId + "@gmail.com",
                        this.idProductor + "@caracoli.com",
                        "Asunto " + contadorId,
                        "Cuerpo del mensaje " + contadorId
                );

                // Condición del pikachu rosa... por qué, césar? XD
                if (this.idProductor == 2) nuevoMail.setDestinatario("pikachu@gmail.com");
                if (!nuevoMail.getDestinatario().equals("pikachu@gmail.com")) {
                    bufferMails.agregarMail(nuevoMail);
                    System.out.println("Maldito Pikachu rosa... siempre queriendo ocupar el buffer");
                }

                // Simular la espera de 0.5 segundos
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupcióooooon");
        }
    }
}
