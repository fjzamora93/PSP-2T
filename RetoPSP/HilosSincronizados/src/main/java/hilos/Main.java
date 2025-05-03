package hilos;

import hilos.model.Consumidor;

public class Main {

    public static void main(String[] args) {
        // Crear el buffer compartido
        Buffer buffer = new Buffer();

        // Crear 3 hilos ProductorMails
        Productor productor1 = new Productor(buffer);
        Productor productor2 = new Productor(buffer);
        Productor productor3 = new Productor(buffer);

        Consumidor consumidor1 = new Consumidor(buffer);
        Consumidor consumidor2 = new Consumidor(buffer);

        // Iniciar los hilos
        productor1.start();
        productor2.start();
        productor3.start();

        consumidor1.start();
        consumidor2.start();
    }
}
