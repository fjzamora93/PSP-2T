package server.service;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Conexión a la API.
 *
 * Se trata de una API de películas muy básica. No puede ni devolver grandes cantidades de datos ni aceptar solicitudes muy complejas, aunque cumple para el ejercicio.
 * */
public class Api {
    private final HttpClient httpClient;

    public Api() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public String get(String endpoint) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
