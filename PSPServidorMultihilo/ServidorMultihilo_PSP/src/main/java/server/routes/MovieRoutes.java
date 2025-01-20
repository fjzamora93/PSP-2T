package server.routes;

import org.json.JSONObject;
import server.controllers.MovieController;
import server.service.MovieService;

/**
 * Esta clase se encarga de clasificar la petición entrnate y enviarla al controlador.
 *
 * EN una API Rest, esto lo veríamos en un sistema de rutas, aunque aquí lo hemos "improvisado" con un switch/case.
 * */
public class MovieRoutes {
    private MovieController movieController;
    private JSONObject response;

    public MovieRoutes() {
        this.movieController = new MovieController(new MovieService());
        this.response = new JSONObject();
    }


    public JSONObject processRequest(JSONObject request) throws Exception {
        String header = request.getString("header");
        String body = request.getString("body");

        switch (header) {
            case "GET/TITLE":
                this.response.put("body", this.movieController.getMovieByTitle(body));
                break;
            case "GET/YEAR":
                this.response.put("body", this.movieController.getMovieByYear(body));
                break;

            case "EXIT":
                this.response.put("body", "CIERRE DE CONEXIÓN");
                break;

            default:
                this.response.put("body", this.movieController.getMovieByTitle(body));
                break;
        }
        return this.response;
    }

}
