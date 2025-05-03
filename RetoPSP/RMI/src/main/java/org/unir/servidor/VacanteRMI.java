package org.unir.servidor;


import org.unir.common.VacanteInterfaceRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class VacanteRMI extends UnicastRemoteObject implements VacanteInterfaceRMI {
    private static final long serialVersionUID = -4817856459999901795L;
    private ArrayList<Vacante> vacantes;

    public VacanteRMI() throws RemoteException {
        super();
        vacantes = new ArrayList<Vacante>();

        vacantes.add(new Vacante(1, "2025-05-03", "Desarrollador Java", "Desarrollo de aplicaciones backend", "TechCorp"));
        vacantes.add(new Vacante(2, "2025-05-02", "Analista de Datos", "Análisis de datos y visualización", "DataSolutions"));
        vacantes.add(new Vacante(3, "2025-04-30", "Diseñador UX/UI", "Diseño de interfaces centradas en el usuario", "Creativa Studio"));
        vacantes.add(new Vacante(4, "2025-04-29", "Administrador de Sistemas", "Mantenimiento de servidores y redes", "InfraRed"));
        vacantes.add(new Vacante(5, "2025-04-28", "Ingeniero DevOps", "Automatización de despliegues y CI/CD", "CloudOps"));


    }

    @Override
    public String findByCompany(String company) throws RemoteException {
        String resultado = "";
        for (Vacante v : vacantes) {
            if (v.getCompanyName().contains(company)) {
                resultado = resultado + v + "\n";
            }
        }
        return resultado;
    }

    @Override
    public String findByTitle(String title) throws RemoteException {
        String resultado = "";
       for (Vacante v : vacantes){
            if (v.getTitle().contains(title)){
                resultado = resultado + v + "\n";
            }
       }
       return resultado;
    }


}
