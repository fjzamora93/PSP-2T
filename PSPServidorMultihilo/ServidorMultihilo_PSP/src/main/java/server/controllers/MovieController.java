package server.controllers;

import server.service.MovieService;
import server.utils.ClientCommunication;

/**
 * Capa lógica del controlador, aunque en este punto no se está aplicando ningún tipo de lógica.
 *
 * En esta capa podríamos recoger los datos del formulario y procesarlos si fuese necesario para gestionar las peticiones entrantes.
 * */
public class MovieController {
    private MovieService movieService;

    public MovieController(
            MovieService movieService
    ) {
        this.movieService = new MovieService();
    }


    public String getMovieByTitle(String title) throws Exception {
        return movieService.findByTitle(title);
    }

    public String getMovieByYear(String year) throws Exception {
        return movieService.findByYear(year);
    }

}
