package server;

import server.service.MovieService;

public class Router {
    private MovieService movieService;

    public Router() {
        this.movieService = new MovieService();
    }

    public String findByTitle(String title) throws Exception {
        return movieService.findByTitle(title);
    }

    public String findByYear(String year) throws Exception {
        return movieService.findByYear(year);
    }

}
