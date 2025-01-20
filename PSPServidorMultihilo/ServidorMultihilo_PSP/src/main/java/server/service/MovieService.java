package server.service;

import config.Constants;


/**
 * Esta capa es un poco "rara", ya que nuestro servidor le está mandando peticiones a otro servidor y se convierte en cliente de este al mismo tiempo.
 * */
public class MovieService {
    private final Api api;

    public MovieService() {
        this.api = new Api();
    }

    public String findByTitle(String title) throws Exception {
        String endpoint = Constants.BASE_URL + "?apikey=" + Constants.API_KEY + "&t=" + title;
        return api.get(endpoint);
    }

    public String findByYear(String year) throws Exception {
        String endpoint = Constants.BASE_URL + "?apikey=" + Constants.API_KEY + "&y=" + year + "&t=" + "main";
        return api.get(endpoint);
    }
}
