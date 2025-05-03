package com.unir.servidor;

import com.unir.common.PlanetaInterfaceRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class PlanetaRMI extends UnicastRemoteObject implements PlanetaInterfaceRMI {

    private static final long serialVersionUID = -4817856459999901798L;
    private ArrayList<Planeta> planetas;

    public PlanetaRMI() throws RemoteException {
        planetas = new ArrayList<>();

        planetas.add(new Planeta("Mercurio", 4879, 57.9));
        planetas.add(new Planeta("Venus", 12104, 108.2));
        planetas.add(new Planeta("Tierra", 12742, 149.6));
        planetas.add(new Planeta("Marte", 6779, 227.9));
        planetas.add(new Planeta("Jupiter", 139820, 778.3));
        planetas.add(new Planeta("Saturno", 116460, 1427));
        planetas.add(new Planeta("Urano", 50724, 2871));
        planetas.add(new Planeta("Neptuno", 49528, 4495));
    }


    @Override
    public String buscarPorNombre(String nombre) throws RemoteException {
        String resultado = "";

        for (Planeta item : planetas) {

            if (item.getNombre().equals(nombre)) {
                resultado = item + "\n";
            }

        }
        return resultado;
    }
}
