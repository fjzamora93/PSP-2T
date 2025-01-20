package client.ui;

import client.Repository.ClientRepository;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.json.JSONObject;
import server.model.Movie;

import java.io.IOException;
import java.util.Scanner;


/**
 * Esta clase se encarga de simular una interfaz de usuario.
 *
 * Ante la opción elegida, llamará al método correspondiente del ViewMOdel, que hará la petición.
 * */
public class MenuScreen {

    private Scanner scanner = new Scanner(System.in);

    private String header;
    private String body;
    private boolean exit = false;


    public  void displayMenu() throws IOException {
        System.out.println("Bienvenido al buscador de películas");
        System.out.println("Introduzca por teclado el número de opción que desea");
        System.out.println("1. Buscar por título");
        System.out.println("2. Buscar por año");
        System.out.println("3. Salir de la aplicación");
    }


    /** En caso de haber un formulario auténtico, utilizaríamos el NAME para recuperar los campos del formulario,
     * pero como estamos en una simulación, haremos la clasificación manualmente*/
    public  JSONObject onOptionSelect() throws IOException {
        String option = "INVALID";
        while (option.equals("INVALID")) {
            option = scanner.nextLine();
            switch ( option){
                case "1":
                    System.out.println("Introduzca el título completo o una parte del título en inglés");
                    this.header = "GET/TITLE";
                    this.body = scanner.nextLine();
                    break;

                case "2":
                    System.out.println("Introduzca el año de la película");
                    this.header = "GET/YEAR";
                    this.body = scanner.nextLine();
                    break;
                case "3":
                    System.out.println("SALIENDO DE LA APLICACIÓN");
                    this.header = "EXIT";
                    this.body = "";
                    this.exit = true;
                    break;
                default:
                    this.header = "INVALID";
                    this.body = "";
                    break;
            }
        }
        // retornar un objeto JSON con un el header + body
        return requestToJson(header, body);
    }


    /** Convertimos la petición a JSON*/
    public JSONObject requestToJson(String header, String body){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("header", this.header);
        jsonObject.put("body", this.body);
        return jsonObject;
    }

    public void displayMovieData(Movie movie) {
        System.out.println(movie.toString());
    }

    public boolean isExit() {
        return exit;
    }


}

