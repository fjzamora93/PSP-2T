package client;

import client.ui.MenuScreen;
import client.controller.ClienteController;
import config.Constants;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * La clase cliente solicita una película al servidor, que este a su vez realizará una petición a la API.
 * */
public class ClientApp {
    public static void main(String[] args) {
        System.out.println(" APLICACIÓN CLIENTE");
        System.out.println("-----------------------------------");
        try {
            Socket cliente = new Socket();
            InetSocketAddress direccionServidor = new InetSocketAddress(Constants.IP_SERVIDOR,Constants.PORT);

            System.out.println("Esperando a que el servidor acepte la conexión");
            cliente.connect(direccionServidor);
            System.out.println("Comunicación establecida con el servidor");

            ClienteController clienteController = new ClienteController(cliente);
            MenuScreen menuScreen = new MenuScreen(clienteController);

            while (clienteController.getIsOPen()) {
                menuScreen.displayMenu();
            }

            clienteController.closeConnection();

        } catch (UnknownHostException e) {
            System.out.println("No se puede establecer comunicación con el servidor");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de E/S");
            System.out.println(e.getMessage());
        }
    }
}
