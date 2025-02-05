package com.unir.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EstrellaInterfaceRMI extends Remote {
    String buscarNombre(String nombre) throws RemoteException;
}
