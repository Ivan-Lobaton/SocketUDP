package scr.SocketCliente;

// Importa las clases necesarias para trabajar con sockets y datagramas UDP.
import java.net.*;

public class SocketUDP_Cliente {
    public static void main(String[] args) {
        try {
            /*
             * Crea un socket UDP para el cliente. Al no especificar un puerto, el sistema
             * operativo asignará automáticamente uno disponible.
             */
            DatagramSocket clientSocket = new DatagramSocket();

            /*
             * Define el mensaje que se enviará al servidor y lo convierte en un array de
             * bytes para ser transmitido.
             */
            String message = "¡Hola Servidor!";
            byte[] sendData = message.getBytes();

            /*
             * Especifica la dirección IP o el nombre del servidor ("localhost" en este
             * caso) y el puerto al que el cliente enviará el datagrama.
             */
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 12345;

            /*
             * Crea un DatagramPacket con los datos a enviar, la dirección y el puerto del
             * servidor. Luego, el datagrama se envía mediante send().
             */
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
            clientSocket.send(sendPacket);

            /*
             * Cierra el socket del cliente para liberar los recursos después de haber
             * terminado la comunicación.
             */
            clientSocket.close();

            /*
             * Cualquier excepción que ocurra durante la ejecución del código se maneja e
             * imprime su traza en la consola.
             */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
