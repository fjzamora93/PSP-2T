package org.unir.servidor;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorRMI {
    public static void main(String[] args) {
        int puerto = 5055;
        try {
            // creamos registro de objetos remotos
            Registry registro = LocateRegistry.createRegistry(puerto);

            // Y creamos el objeto remoto que debemos añadir al registro
            VacanteRMI vacanteRMI = new VacanteRMI();

            //Inscripción del objeto en el registro
            registro.rebind("miVacante", vacanteRMI);

            System.out.println("Servicio registrado en localhost puerto " + puerto);
        } catch (RemoteException e) {
            System.out.println("No se ha podido registrar el servicio");
            System.out.println(e.getMessage());
        }
    }
}