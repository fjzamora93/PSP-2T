package server;

import server.service.MovieService;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

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

            BufferedReader reader = new BufferedReader(new InputStreamReader(entrada, StandardCharsets.UTF_8));
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(salida, StandardCharsets.UTF_8), true);

            String texto;
            while ((texto = reader.readLine()) != null) {

                if (texto.trim().equals("FIN")) {
                    writer.println("Hasta pronto, gracias por establecer conexión");
                    System.out.println(hilo.getName()+" ha cerrado la comunicación");
                } else {
                    System.out.println(hilo.getName() + " dice: " + texto);
                    String researchResult = movieService.findByTitle(texto);
                    writer.println(researchResult);
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