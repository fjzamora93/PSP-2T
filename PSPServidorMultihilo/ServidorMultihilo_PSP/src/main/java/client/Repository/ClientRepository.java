package client.Repository;

import java.io.*;
import java.net.Socket;


/**
 * ARQUITECTURA:
 *
 * - Si la respuesta va a ser parseada y utilizada directamente, se puede quedar dentro del repositorio.
 * - Si es necesario aplicar lógica adicional, crear una clase "ControllerCLient" y aplicar ahí la lógica de negocio.
 * */
public class ClientRepository {
    public   Socket cliente;
    private  InputStream entrada;
    private  OutputStream salida;

    private  BufferedReader reader;
    private  PrintWriter writer;

    private  Boolean isOPen = true;

    public ClientRepository(Socket cliente) throws IOException {
        this.cliente = cliente;
        this.entrada = cliente.getInputStream();
        this.salida = cliente.getOutputStream();
        this.reader = new BufferedReader(new InputStreamReader(entrada));
        this.writer = new PrintWriter(new OutputStreamWriter(salida), true);
    }

    public  String findByTitle(String title) throws IOException {
        writer.println(title);
        System.out.println("Find by " + title);
        return reader.readLine();
    }

    public  String findByYear(String year) throws IOException {
        writer.println(year);
        System.out.println("Find by " + year);
        return reader.readLine();
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
