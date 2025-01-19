package server.service;

import config.Constants;
import server.Api;

public class MovieService {
    private final Api api;

    public MovieService() {
        this.api = new Api();
    }

    public String findByTitle(String title) throws Exception {
        String endpoint = Constants.BASE_URL + "?apikey=" + Constants.API_KEY + "&t=" + title;
        return api.get(endpoint);
    }
}
