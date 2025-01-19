package client.ui;

import client.controller.ClienteController;

import java.io.IOException;
import java.util.Scanner;


/**
 * Esta clase se encarga de simular una interfaz de usuario.
 *
 * Ante la opción elegida, llamará al método correspondiente del ViewMOdel, que hará la petición.
 * */
public class MenuScreen {

    private Scanner scanner = new Scanner(System.in);
    private ClienteController clienteController;

    public MenuScreen(ClienteController clienteController) {
        this.clienteController = clienteController;
    }


    public  void displayMenu() throws IOException {
        System.out.println("Bienvenido al buscador de películas");
        System.out.println("Introduzca por teclado el número de opción que desea");
        System.out.println("1. Buscar por título");
        System.out.println("2. Buscar por año");
        switchOption(scanner.nextLine());
    }

    public  void switchOption(String option) throws IOException {
        switch ( option){
            case "1":
                System.out.println("Introduzca el título completo o una parte del título en inglés");
                clienteController.findByTitle(scanner.nextLine());

                break;
            case "2":
                System.out.println("Introduzca el año de la película");
                clienteController.findByYear(scanner.nextLine());
                break;
        }
    }

}
