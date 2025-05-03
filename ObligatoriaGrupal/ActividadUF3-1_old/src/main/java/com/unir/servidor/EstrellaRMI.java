package com.unir.servidor;

import com.unir.common.EstrellaInterfaceRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class EstrellaRMI  extends UnicastRemoteObject implements EstrellaInterfaceRMI
{
    private static final long serialVersionUID = -4817856459999901795L;
    private ArrayList<Estrella> estrellas;
    public EstrellaRMI() throws RemoteException {
        super();
        estrellas = new ArrayList<Estrella>();
        estrellas.add(new Estrella("Sirio", "La estrella más brillante del cielo nocturno, en la constelación del Can Mayor."));
        estrellas.add(new Estrella("Betelgeuse", "Una supergigante roja en la constelación de Orión."));
        estrellas.add(new Estrella("Rigel", "Una de las estrellas más brillantes, ubicada en Orión."));
        estrellas.add(new Estrella("Aldebarán", "Estrella roja en la constelación de Tauro, visible a simple vista."));
        estrellas.add(new Estrella("Vega", "Parte del triángulo de verano, en la constelación de Lira."));
        estrellas.add(new Estrella("Capella", "La estrella más brillante de la constelación de Auriga."));
        estrellas.add(new Estrella("Antares", "Estrella roja y gigante en la constelación de Escorpio."));
        estrellas.add(new Estrella("Arcturus", "Estrella naranja muy brillante en la constelación del Boyero."));
        estrellas.add(new Estrella("Spica", "Estrella azul-blanca en la constelación de Virgo."));
        estrellas.add(new Estrella("Polaris", "La estrella polar, ubicada en la constelación de la Osa Menor."));
        estrellas.add(new Estrella("Altair", "Parte del triángulo de verano, ubicada en la constelación del Águila."));
    }

    @Override
    public String buscarNombre(String titulo) throws RemoteException {
        String resultado = "";
        for (Estrella star : estrellas) {
            if (star.getNombre().contains(titulo)) {
                resultado = resultado + star + "\n";
            }
        }
        return resultado;
    }


}