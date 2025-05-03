package com.unir.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PlanetaInterfaceRMI extends Remote {

    String buscarPorNombre(String nombre) throws RemoteException;
}
