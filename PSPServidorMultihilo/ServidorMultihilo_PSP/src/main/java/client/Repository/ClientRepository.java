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
 * -EN un principio este repositorio solamente debería establecer la comunicación con el servidor.
 *
 * - Sin embargo, está aplicando también una capa lógica al procesar la información que se recibe.
 *
 * - Idealmente, este procesamiento de información debería quedar en otra capa intermedia entre el repositorio y la interfaz por consola.
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

    /** TODO: El repositorio no debería parsear la respuesta, debería enviarla a otra capa que la procese correctamente
     *
     * En caso de que dicha capa tuviese headers, debería leerlos correctamente y actuar en consecuencia.
     *
     * Para simplificar el código, hemos eliminado ese trámite y directamente enviamos la respuesta ya parseada y convertida en una clase de Java.
     * */
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
