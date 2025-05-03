package com.unir.cliente;
import com.unir.common.ConstelacionInterfaceRMI;
import com.unir.common.EstrellaInterfaceRMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
public class ClienteCieloNocturno {
    public static void main(String[] args) {
        Registry registry;
        Scanner lector = new Scanner(System.in);
        try {
            //La parte importante del código, que permite al cliente obtener el stub para comunicarse con el
            //objeto remoto,
            //obtener el acceso al registro de objetos remotos a través de la misma dirección IP y puerto suministrado
            //acordaos de cambiar la IP
            registry = LocateRegistry.getRegistry("192.168.1.156", 5055);
            System.out.println("Hemos obtenido el registro");
            //stub a partir del identificador del objeto suministrado en el programa servidor

            ConstelacionInterfaceRMI contelaciones = (ConstelacionInterfaceRMI) registry.lookup("miConstelacion");
            EstrellaInterfaceRMI estrellas = (EstrellaInterfaceRMI) registry.lookup("miEstrella");

            System.out.println("Hemos obtenido el objeto remoto");
            System.out.println();
            String buscado;
            String opcion = "";
            do {
                escribirMenu();
                opcion = lector.nextLine().toUpperCase();
                switch (opcion) {
                    case "C":
                        System.out.println("Escribe nombre Constelación: ");
                        buscado = lector.nextLine();
                        System.out.println(contelaciones.buscarNombre(buscado));
                        break;
                    case "E":
                        System.out.println("Escribe nombre Estrella: ");
                        buscado = lector.nextLine();
                        System.out.println(estrellas.buscarNombre(buscado));
                        break;
                    case "FIN":
                        System.out.println("Programa finalizado");
                        break;
                    default:
                        System.out.println("Opción incorrecta");
                }
            } while (!opcion.equals("FIN"));
        } catch (RemoteException | NotBoundException e) {
            System.out.println(e.getMessage());
        }
        lector.close();
    }
    private static void escribirMenu() {
        System.out.println();
        System.out.println("Escribe el nombre de la constelación");
        System.out.println("--------------------------");
        System.out.println("FIN = Para cerrar programa");
        System.out.println("C = Constelación");
        System.out.println("E = Estrella");

    }
}