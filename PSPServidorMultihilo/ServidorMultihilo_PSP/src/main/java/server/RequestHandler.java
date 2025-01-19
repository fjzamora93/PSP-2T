package server;

import server.service.MovieService;

/**
 * ¿PARA QUÉ CREAR UNA CLASE QUE "INTERCEPTA" EL MENSAJE?
 *
 * Al comenzar el ejercicio, el texto que recibía venía en formato de texto plano,
 * aunque ciertamente aún no tenía definido si la petición sería un JSON con solo una palabra clave,
 * o sería una búsqueda avanzada que incluyese varios campos.
 *
 * COn el fin de dejar abierto el ejercicio a varias posibles peticiones,
 * hemos creado esta capa que se encarga de interpretar el mensaje correctamente.
 * */
public class RequestHandler {
    private Router router;
    private String response;

    public RequestHandler() {
        this.router = new Router();
    }

    public String processRequest(String request) throws Exception {
        switch (request) {
            case "GET/TITLE":
                this.response = this.router.findByTitle(request);
                break;
            case "GET/YEAR":
                this.response =  this.router.findByYear(request);
                break;

                // SUPUESTO DE CIERE DE CONEXIÓN
            case "3":
                break;
            default:
                this.response = this.router.findByTitle(request);
                break;
        }
        return this.response;
    }

}
