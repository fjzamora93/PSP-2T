# 1. Creamos el interface RMI

Comenzamos creando un interface de RMI. 

- Este interface debe estar tanto en el lado del servidor como en el lador del cliente. 
- Extiende la clase Remote.
- Cada método del interface debe arrojar RemoteException.


```java

public interface VacanteInterfaceRMI extends Remote {
   
   // Aquí declaramos los métodos que deben implementarse... por ejemplo
   String findByCompany(String nombre) throws RemoteException;

}

```


# 2. Creamos el servidor

Una vez hemos creado el Interface del RMI, podemos ir al servidor y creamos las siguientes clases:


###  class Servidor

Su única función es exponer el puerto y enviar la información al cliente. Como dato llamativo, debe hacer un rebind() para identificar el RMI que se va a enviar. Esto es algo que realizará en tres fases:

1. Crear un registro (Registry.createRegistry(puerto)
2. Instanciar el objeto RMI.
3. Registarr el objeto RMI en el registro para que pueda llegar al cliente.

UN registro puede hacer rebind a tantos objetos RMI como queramos. Simplemtne necesitaremos crear una clase RMI para cada objeto remoto que queramos enviar al cliente.

```java

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
```
Solamente siguiendo un LocateRegistry.createRegistry(puerto) el servidor ya se va a quedar activo en ese puerto. NO hay que hacer nada más para que el cliente acceda.


### Modelo

Es un modelo al uso, no representa nada nuevo. Simplemente es cualquiera de los objetos que pueden estar dentro del RMI. Por ejemplo:

```java
public class Vacante {
    private int id;
    private String title;
}
```




### ModeloRMI

La clase que va a contener el objeto que vamos a enviar al cliente. Esta clase puede tener todos los atributos que necesitemos así como todos los métodos implementados que haya definido el interface.

Consideraciones:
1. Debe extender la clase UnicastRemoteObject.
2. Debe implementar el interface asociado (que estará en cliente y servidor).
3. Debe hacer un throws del RemoteException en el constructor y en cada método que implemente.

```java

public class VacanteRMI extends UnicastRemoteObject implements VacanteInterfaceRMI {
    private static final long serialVersionUID = -4817856459999901795L;
    private ArrayList<Vacante> vacantes;

    public VacanteRMI() throws RemoteException {
        super();
        vacantes = new ArrayList<Vacante>();
        vacantes.add(new Vacante(1, "2025-05-03", "Desarrollador Java", "Desarrollo de aplicaciones backend", "TechCorp"));

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

}

```




# 2. Creamos el cliente

EL cliente debe seguir los siguientes pasos:

- Crear un Registry y conectarse a la ip y puerto del servidor.
- Usa el método lookup del registry para crear el stub (representación del objeto remoto del servidor).
- A partir de es emomento, usar los métodos del stub libremente, sin tener que crear el stub a nivel local.


```java

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
            
            // Llamamos a cualquier método que queramos del stub
            stub.findAll()
}

```






