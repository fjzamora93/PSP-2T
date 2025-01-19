package server;

import java.io.*;
import java.net.Socket;

public class HiloEscuchador implements Runnable{
    private Thread hilo;
    private static int numCliente = 0;
    private Socket enchufeAlCliente;
    private MovieService movieService;


    public HiloEscuchador(Socket cliente) {
        numCliente++;
        hilo = new Thread(this, "Cliente"+numCliente);
        this.enchufeAlCliente = cliente;
        hilo.start();
        movieService = new MovieService();
    }
    @Override
    public void run() {
        System.out.println("Estableciendo comunicación con " + hilo.getName());
        try {
            InputStream entrada = enchufeAlCliente.getInputStream();
            OutputStream salida = enchufeAlCliente.getOutputStream();
            String texto = "";
            while (!texto.trim().equals("FIN")) {
                byte[] mensaje = new byte[100];
                entrada.read(mensaje);
                texto = new String(mensaje).trim();

                if (texto.trim().equals("FIN")) {
                    salida.write("Hasta pronto, gracias por establecer conexión".getBytes());
                    System.out.println(hilo.getName()+" ha cerrado la comunicación");
                } else {
                    System.out.println(hilo.getName() + " dice: " + texto);
                    String researchResult = movieService.buscarPelicula(texto);
                    salida.write(("Resultados de la búsqueda en el HiloEscuchador " + researchResult).getBytes());
                }
            }
            entrada.close();
            salida.close();
            enchufeAlCliente.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}