package server;

import server.service.MovieService;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class HiloEscuchador implements Runnable{
    private Thread hilo;
    private static int numCliente = 0;
    private Socket enchufeAlCliente;
    private RequestHandler requestHandler;

    public HiloEscuchador(Socket cliente) throws IOException {
        this.requestHandler = new RequestHandler();
        numCliente++;
        hilo = new Thread(this, "Cliente"+numCliente);
        this.enchufeAlCliente = cliente;
        hilo.start();
    }


    @Override
    public void run() {
        System.out.println("Estableciendo comunicación con " + hilo.getName());
        try {
            ClientCommunication communication = new ClientCommunication(this.enchufeAlCliente);
            String texto;
            while ((texto = communication.readRequest()) != null) {
                String response = requestHandler.processRequest(texto);
                communication.sendResponse(response);
            }
            communication.close();
            enchufeAlCliente.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}