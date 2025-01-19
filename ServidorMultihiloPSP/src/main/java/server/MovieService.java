package server;

import config.Constants;

public class MovieService {
    private final Api apiClient;

    public MovieService() {
        this.apiClient = new Api();
    }

    public String buscarPelicula(String titulo) throws Exception {
        String endpoint = Constants.BASE_URL + "?apikey=" + Constants.API_KEY + "&t=" + titulo;
        return apiClient.get(endpoint);
    }
}
