# Actividad de conexión cliente-servidor con multihilo

La actividad obligatoria del 2T pretende simular una arquitectura de conexión cliente-servidor utilizando un proceso de multihilo.

Para establecer una diferenciación, se ha seguido una arquitectura diferente para el cliente y para el servidor.

## Instrucciones
1. Ejecutar la clase 'ServidorApp'
2. EJecutar la clase 'ClienteApp'
3. Realizar peticiones por consola a través de CLienteApp. 

**Las peticiones pueden ser las siguientes**
- 1, 2, 3, para seleccionar la opción del menú.
- Un texto que puede formar parte del título de la película, o el año en el que se lanzó.

La respuesta siempre será una sola película, no hay opción a recibir más con el objetivo de simplificar el código.

En caso de que en un futuro se quisieran recibir varios resultados de búsqueda, se deben cambiar los parámetros de la petición y rempalzar el &t (que solo devuelve el primer resultado) por un &s (que devuelve una lista completa).



## Cliente

Para el cliente se han creado 3 capas:
- La de la aplicación principal (CLienteAPp).
- Una capa que pretende simular una interfaz de usuario -en este caso, una interfaz por consola.
- Un repositorio donde desde donde se lanzan las peticiones al servidor y se reciben las respuestas.

Adicionalmente, propondría crear una capa intermediaria entre el repositorio y la interfaz por consola que actúe de controlador para realizar las validaciones pertinentes y que tome decisiones en función del tipo de respuesta recibida o la petición enviada.

Por ejemplo, verificar si los headers y cuerpo son correctos, o, al recibir una respuesta, verificar también los headers y actuar en consecuencia del tipo de dato que se está recibiendo.


## Servidor 

La arquitectura del servidor es una simulación de una API Rest (aunque aplicando solamente los conocimientos vistos en clase hasta ahora).

Para ello, se ha seguido la siguiente arquitectura:
- UN sistema de rutas, que pretende imitar el de las peticiones de HTTPS.
- UN controlador, que actúa como intermediaria para aplicar cierta lógica al enviar las respuestas.
- UNa capa de comunicación que es la que finalmente se encarga de enviar y recibir las respuestas.
- Un modelo para guardar y serializar la película y un servicio (para solicitar datos a una API externa, ya que no tenemos datos propios).



