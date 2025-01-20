package server.service;

import config.Constants;


/**
 * Esta capa es un poco "rara", ya que nuestro servidor le está mandando peticiones a otro servidor y se convierte en cliente de este al mismo tiempo.
 *
 * INSTRUCCIONES DE LA API
 * - EL parámetro &t únicamente devuelve un solo resultado.
 *
 * EJEMPLO:
 * http://www.omdbapi.com/?apikey=f9c39ba3&t=game
 * SOlamente devolverá el primer resultado de la lista, que en este caso es 'Game of Thrones'.
 *
 * - EL parámetro &s devolverá una lista de películas.
 *
 * EJEMPLO:
 * * http://www.omdbapi.com/?apikey=f9c39ba3&s=game
 *Devolverá una lista con vairas series y películas que contenga la palabra "game" en el título.
 *
 *
 *POr simplificar al máximo las peticiones, simplemente se va a recibir una sola película a la vez.
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
