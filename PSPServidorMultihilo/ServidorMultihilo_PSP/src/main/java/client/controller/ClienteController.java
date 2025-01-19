package client.controller;

import java.io.*;
import java.net.Socket;

public class ClienteController {
    public   Socket cliente;
    private  InputStream entrada;
    private  OutputStream salida;

    private  BufferedReader reader;
    private  PrintWriter writer;

    private  Boolean isOPen = true;

    public ClienteController(Socket cliente) throws IOException {
        this.cliente = cliente;
        this.entrada = cliente.getInputStream();
        this.salida = cliente.getOutputStream();
        this.reader = new BufferedReader(new InputStreamReader(entrada));
        this.writer = new PrintWriter(new OutputStreamWriter(salida), true);
    }

    public  void findByTitle(String title) throws IOException {
        writer.println(title);
        System.out.println("Find by " + title);
        String respuesta = reader.readLine();
        System.out.println("El servidor responde: " + respuesta);

    }

    public  void findByYear(String year) throws IOException {
        writer.println(year);
        System.out.println("Find by " + year);
        String respuesta = reader.readLine();
        System.out.println("El servidor responde: " + respuesta);

    }

    public void closeConnection() throws IOException {
        entrada.close();
        salida.close();
        cliente.close();
        isOPen = false;
        System.out.println("Comunicación cerrada");
    }

    public  Boolean getIsOPen() {
        return isOPen;
    }

}
