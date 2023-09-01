SocketUDP - Comunicación de Cliente a Cliente pasando por un Servidor

Este proyecto ejemplifica el uso del protocolo de Datagrama de Usuario (UDP) en Java para establecer una 
comunicación simple entre dos clientes y un servidor. El objetivo es que el Cliente1 envíe un mensaje al 
Cliente2, pero dicho mensaje debe pasar por el servidor para llegar al Cliente2.

Estructura:

El proyecto se divide en tres clases Java:
1. SocketUDP_Servidor: Esta clase representa el servidor que actúa como intermediario para reenviar mensajes 
del Cliente1 al Cliente2.
2. SocketUDP_Cliente1: Este es el primer cliente que envía un mensaje al servidor.
3. SocketUDP_Cliente2: Este es el segundo cliente que recibe un mensaje del servidor.

Funcionamiento:

El servidor se encarga de escuchar constantemente en un puerto específico (en este caso, el puerto 12345).
Cuando recibe un mensaje del Cliente1, lo reenvía al Cliente2. Los pasos principales son los siguientes:

1. Cliente1 envía un mensaje al servidor: El Cliente1 crea un paquete que contiene su mensaje, lo convierte 
en bytes y lo envía al servidor especificando la dirección IP del servidor y el puerto del servidor. 
El servidor escucha en este puerto y recibe el mensaje.
2. El servidor reenvía el mensaje al Cliente2: El servidor toma el mensaje recibido del Cliente1 y lo envía 
al Cliente2 de manera similar, convirtiéndolo en bytes y especificando la dirección IP y el puerto del 
Cliente2.
3. Cliente2 recibe el mensaje del servidor: El Cliente2 escucha en su puerto específico y recibe el mensaje 
del servidor. Luego, muestra el mensaje en la consola.

Configuración:

1. Asegúrate de tener Java instalado en tu sistema.
2. Ejecuta primero el servidor, luego el Cliente1 y, finalmente, el Cliente2.
3. El servidor está configurado para escuchar en localhost (la misma máquina). Puedes cambiar la dirección IP 
a la del servidor si está en una máquina diferente.
4. El proyecto utiliza el puerto 12345 para la comunicación, asegúrate de que este puerto esté disponible en 
tu máquina.