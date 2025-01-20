package client.Repository;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.json.JSONObject;
import server.model.Movie;

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

    public  void sendRequest(JSONObject request) throws IOException {
        writer.println(request);
        System.out.println("Petición lanzada " + request);
    }

    public Movie receiveResponse() throws IOException {
        String response =  reader.readLine();
        Gson gson = new Gson();

        JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
        String bodyJson = jsonObject.get("body").getAsString();

        Movie movie = gson.fromJson(bodyJson, Movie.class);
        return movie;
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
