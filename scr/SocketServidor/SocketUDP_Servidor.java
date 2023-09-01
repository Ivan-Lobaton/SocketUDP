package scr.SocketServidor;

// Importa las clases necesarias para trabajar con sockets y datagramas UDP.
import java.net.*;

public class SocketUDP_Servidor {
    public static void main(String[] args) {
        try {
            /*
             * Crea un socket UDP en el puerto 12345, que es el puerto en el que el servidor
             * espera recibir datagramas.
             */
            DatagramSocket serverSocket = new DatagramSocket(12345);

            /*
             * Crea un buffer receiveData y un DatagramPacket receivePacket para recibir los
             * datos enviados por el cliente.
             */
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            System.out.println("Esperando la conexión del cliente UDP...");

            /*
             * El servidor entra en modo de espera y recibe el datagrama del cliente en el
             * receivePacket.
             */
            serverSocket.receive(receivePacket);

            /*
             * Convierte los datos recibidos en un String y obtiene la dirección IP y el
             * puerto del cliente.
             */
            String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();

            /*
             * Muestra en la consola el mensaje recibido del cliente y la dirección IP y el
             * puerto del cliente.
             */
            System.out.println("Mensaje recibido del cliente: " + receivedMessage);
            System.out.println("Desde: " + clientAddress + ":" + clientPort);

            /*
             * Cierra el socket del servidor para liberar los recursos después de haber
             * terminado la comunicación.
             */
            serverSocket.close();

            /*
             * Cualquier excepción que ocurra durante la ejecución del código se maneja e
             * imprime su traza en la consola.
             */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
