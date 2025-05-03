package org.unir.cliente;

import org.unir.common.VacanteInterfaceRMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class ClienteVacante {
    public static void main(String[] args) {
        Registry registro;
        Scanner lector = new Scanner(System.in);
        try {
            //La parte importante del código, que permite al cliente obtener el stub para comunicarse con el objeto remoto,
            //obtener el acceso al registro de objetos remotos a través de la misma dirección IP y puerto suministrado acordaos de cambiar la IP
            registro = LocateRegistry.getRegistry("localhost", 5055);
            System.out.println("Hemos obtenido el registro");


            //Creamos el Stub. El stub es lo que representa al objeto remoto cuando se crea en el cliente.
            VacanteInterfaceRMI stub = (VacanteInterfaceRMI) registro.lookup("miVacante");

            System.out.println("Hemos obtenido el objeto remoto");
            String buscado;
            String opcion = "";
            do {
                escribirMenu();
                opcion = lector.nextLine().toUpperCase();
                switch (opcion) {
                    case "C":
                        System.out.println("Escribe nombre Compañía: ");
                        buscado = lector.nextLine();
                        System.out.println(stub.findByCompany(buscado));
                        break;
                    case "T":
                        System.out.println("Escribe título de la Vacante: ");
                        buscado = lector.nextLine();
                        System.out.println(stub.findByTitle(buscado));
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
        System.out.println("C = Compañía");
        System.out.println("T = Nombre de la vacante");

    }
}
