# Repositorio CESAR RMI

CLIENTE RMI
https://github.com/CESAR-UNIRFP/PSP/tree/main/T3-CLIENTE-RMI


SERVIDOR RMI
https://github.com/CESAR-UNIRFP/PSP/tree/main/T3-SERVER-RMI



# Enunciado: 

Esta práctica consiste en la implementación de un servidor RMI que atenderá peticiones de clientes que desean consultar información sobre las constelaciones que cubren nuestro cielo nocturno.

- Debes crear un proyecto en Intellij con el nombre ActividadUF3-1, atendiendo a las especificaciones que se indican en este documento.

- Empaquetarás el proyecto en un archivo .zip que entregarás a tu tutor, junto con un documento en formato Word o PDF donde harás una exposición sobre lo que has ido realizando y pegarás las partes principales del código.

## Especificaciones:

    Para el desarrollo del programa servidor debes basarte en el ejemplo desarrollado a lo largo de la lección “3.2. Programación de servicios en la red” en el apartado “Ejemplo práctico RMI: el programa servidor”.
    
- El cliente se comunicará con el servidor enviando el nombre de una constelación o el texto FIN para cerrar la comunicación.
    
- El servidor responderá enviando al cliente un texto con información sobre la constelación recibida.
    
- Los datos de las constelaciones se guardarán en una colección Java de tipo ArrayList llamada constelaciones que contendrá objetos de la clase Constelacion. Cada objeto Constelacion se compone de las propiedades nombre y observaciones.

- Para facilitarte la labor puedes copiar y pegar estás líneas de código que añaden los distintos objetos Constelacion a la colección de constelaciones.

```java
constelaciones.add(new Constelacion("Osa Mayor", "Se desplaza en círculos alrededor del polo norte."));

constelaciones.add(new Constelacion("Osa Menor", "Su estrella más conocida es la polar que se encuentra en la prolongación del eje de la tierra."));

constelaciones.add(new Constelacion("Tauro", "Una de las constelaciones más conocidas desde tiempos remotos."));

constelaciones.add(new Constelacion("Leo", "De las más brillantes del Zodíaco."));

constelaciones.add(new Constelacion("Escorpio", "Sus estrellas forman un escorpión."));

constelaciones.add(new Constelacion("Can Mayor", "Contiene la estrella Sirio, la más brillante en el cielo nocturno."));

constelaciones.add(new Constelacion("Casiopea", "Tiene forma de M o W. Es conocida desde mucha antigüedad."));

constelaciones.add(new Constelacion("El Boyero", "Contiene la estrella Arturo, uno de las más luminosas del cielo."));

constelaciones.add(new Constelacion("Cruz del sur", "Señala al polo sur. Constelación muy pequeña."));

constelaciones.add(new Constelacion("Acuario", "Una de las más antiguas. Incluye 56 estrellas."));

constelaciones.add(new Constelacion("Géminis", "Destaca por sus dos gemelos, las estrellas Cástor y Pólux."));
```
 

## Parte 2:

Implementa un segundo Objeto compartido a tu elección e implementa la consulta en el cliente para elegir la busqueda sobre uno u otro objeto.
