package org.unir.common;

import org.unir.servidor.Vacante;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface VacanteInterfaceRMI extends Remote {
    String findByCompany(String nombre) throws RemoteException;

    String findByTitle(String title) throws RemoteException;

}
