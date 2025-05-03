# Hilos sincronizados

Pasos a seguir:
- Crear una clase Productor.
- Crear una clase Consumidor.
- Crear una clase Buffer


# 1. CReamos un buffer

El buffer simplemente es un objeto donde se van a ir añadiendo o quitando elementos. En nuestro ejemplo constará de lo siguiente:

1. Los objetos y los métodos que necesitemos (como una lista con métodos de añadir y quitar).
2. Métodos Synchronized que permitan el acceso controlado (todos los métodos serán public synchronized)
3. Llamadas a wait() - para esperar si no hay nada que hacer 
4. Llamadas notify() o notifyALl() para despertar a uno o a todos los que estén esperando.


```java

public class Buffer {
    // Atributo para almacenar la lista de mails
    private LinkedList<Vacante> listaVacantes;

    // Constructor
    public Buffer() {
        this.listaVacantes = new LinkedList<>();
    }

    // Método para agregar una vacante a la lista
    public synchronized void produce(Vacante vacante) {
        listaVacantes.add(vacante);
        System.out.println("Postulando candidatura para la vacante " + vacante.getTittle() + " con ID " + vacante.getId());
        notify(); // Despierta a un consumidor esperando
    }

    public synchronized Vacante consume() {
        while (listaVacantes.isEmpty()) {
            try {
                wait(); // Espera a que haya vacantes
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        Vacante vacante = listaVacantes.remove();
        System.out.println("Creado nuevo puesto " + vacante.getTittle() + " con ID " + vacante.getId());
        return vacante;
    }
}
```

EN este caso vemos:

1. Todos los métodos son SYnchronized.
2. SI la lista está vacía, no hay nada que hacer y el consumer entra en wait.
3. Cada vez que un productor produce, llama a notify para despertar a un consumidor dormido.



# 2. Creamos el Productor

La clase Productor debe hacer lo siguiente:

1. Extender la clase Thread.
2. Acceder a un buffer compartido (para ello crearemos luego un buffer).
3. Sobreescribir el método "run" y aplicar la lógica de lo que debe hacer (ir añadiendo al buffer). 


```java
public class Productor extends Thread {
    private Buffer buffer;
    private int contadorId;
    private static int idProductor;

    // Constructor
    public Productor(Buffer buffer) {
        this.buffer = buffer;
        this.contadorId = 1;
        idProductor++;
    }
    
    /** Introduce un mail en el buffer cada 0.5 segundos */
    @Override
    public void run() {
        try {
            while (this.contadorId <= 10) {
                this.contadorId ++;
                Vacante nuevoVacante = new Vacante(
                        "Nº de la vacante: " + contadorId,
                        "Esta es la vacante para el puesto nº"+ this.idProductor*7 ,
                        "0" + contadorId + "/05/2025",
                        "Para la empresa Nº: " + contadorId*3
                );
                buffer.produce(nuevoVacante);
                // Simular la espera de 0.5 segundos
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrumpido el hilo productor");
        }
    }
}


```


# 2. Creamos el Consumidor

Aquí es donde debemos realizar la sincronización y evitar condiciones de carrera. Al igual que en el Productor, comenzamos extendiendo la clase Thread, ya que cada instancia del consumidor debe representar un nuevo hilo.

1. Extends Thread.
2. Acceso al buffer en el constructor.
2. Override el método run.


```java

public class Consumidor extends Thread {
    private Buffer buffer;

    // Constructor
    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }

    /** Consume un mail del buffer cada 0.5 segundos */
    @Override
    public void run() {
        try {
            int numeroIntento = 0;
            while (numeroIntento < 5) {
                Vacante vacanteConsumido = buffer.consume();
                if (vacanteConsumido != null) {
                    System.out.println("Se consumió el mail con ID: " + vacanteConsumido.getId());
                } else {
                    numeroIntento++;
                    System.out.println("INtento número " + numeroIntento);
                }
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("El hilo consumidor fue interrumpido.");
        }
    }
}
```


