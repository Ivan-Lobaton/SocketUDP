SocketUDP en Java - Guía de Uso

Este archivo README proporciona una guía básica sobre el funcionamiento de los sockets UDP utilizando los 
códigos de programación en Java proporcionados.

Descripción:
El protocolo de datagramas de usuario (UDP) es un protocolo de transporte que permite la comunicación entre 
dispositivos a través de la transmisión de paquetes de datos independientes. Este tipo de comunicación es 
útil para transferencias rápidas y sin garantía de entrega y recepción en un entorno de red.

SocketUDP_Servidor:
La clase SocketUDP_Servidor implementa un servidor UDP que escucha en el puerto 12345 para recibir mensajes 
de los clientes. Los pasos clave son:

1. Crear un DatagramSocket en el puerto deseado.
2. Definir un búfer para recibir los datos y un DatagramPacket para recibir el paquete.
3. Esperar la conexión del cliente usando el método receive().
4. Extraer y mostrar el mensaje recibido, la dirección del cliente y el puerto.
5. Cerrar el socket del servidor después de la comunicación.

SocketUDP_Cliente:
La clase SocketUDP_Cliente implementa un cliente UDP que envía un mensaje al servidor en la dirección 
"localhost" (127.0.0.1) y el puerto 12345. Los pasos clave son:

1. Crear un DatagramSocket para el cliente.
2. Definir el mensaje y convertirlo en bytes.
3. Definir la dirección del servidor y el puerto al que se enviarán los datos.
4. Crear un DatagramPacket para el envío y enviarlo mediante send().
5. Cerrar el socket del cliente después del envío.

Uso:
1. Ejecute SocketUDP_Servidor para iniciar el servidor.
2. Ejecute SocketUDP_Cliente para enviar un mensaje al servidor.
3. Verifique la consola del servidor para ver el mensaje recibido y la dirección del cliente.
4. Cierre la aplicación del servidor después de su uso.

Notas:
1. Este ejemplo es básico y no implementa mecanismos de confirmación de recepción ni manejo de errores.
2. Asegúrese de que no haya conflictos de puertos en uso.
3. Para comunicación a través de redes, modifique la dirección IP del servidor en SocketUDP_Cliente.