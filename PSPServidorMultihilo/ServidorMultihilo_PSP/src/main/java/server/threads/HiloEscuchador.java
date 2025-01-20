package server.threads;

import org.json.JSONObject;
import server.controllers.MovieController;
import server.routes.MovieRoutes;
import server.utils.ClientCommunication;

import java.io.*;
import java.net.Socket;

public class HiloEscuchador implements Runnable{
    private Thread hilo;
    private static int numCliente = 0;
    private Socket enchufeAlCliente;
    private MovieRoutes movieRoutes;

    public HiloEscuchador(Socket cliente) throws IOException {
        this.movieRoutes = new MovieRoutes();
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

            JSONObject request;
            while ((request = communication.readRequest()) != null) {
                JSONObject response = movieRoutes.processRequest(request);
                System.out.println("Tratando den enviar respuesta..." + response);
                communication.sendResponse(response);
            }
            communication.close();
            enchufeAlCliente.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Y se fué...");
        } catch (Exception e) {
            System.out.println("Cerrando conexión");
        } finally {
            try {
                enchufeAlCliente.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}