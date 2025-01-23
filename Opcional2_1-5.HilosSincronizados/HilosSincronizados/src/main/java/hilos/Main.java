package hilos;

import hilos.model.ConsumidorMails;

public class Main {

    public static void main(String[] args) {
        // Crear el buffer compartido
        BufferMails buffer = new BufferMails();

        // Crear 3 hilos ProductorMails
        ProductorMails productor1 = new ProductorMails(buffer);
        ProductorMails productor2 = new ProductorMails(buffer);
        ProductorMails productor3 = new ProductorMails(buffer);

        ConsumidorMails consumidor1 = new ConsumidorMails(buffer);
        ConsumidorMails consumidor2 = new ConsumidorMails(buffer);

        // Iniciar los hilos
        productor1.start();
        productor2.start();
        productor3.start();

        consumidor1.start();
        consumidor2.start();
    }
}
