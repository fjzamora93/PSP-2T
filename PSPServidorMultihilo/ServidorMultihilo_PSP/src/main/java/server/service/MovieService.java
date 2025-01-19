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

    public String findByYear(String year) throws Exception {
        String endpoint = Constants.BASE_URL + "?apikey=" + Constants.API_KEY + "&y=" + year;
        return api.get(endpoint);
    }
}
