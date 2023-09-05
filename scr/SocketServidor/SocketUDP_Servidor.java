package scr.SocketServidor;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class SocketUDP_Servidor {
    public static void main(String[] args) {
        final int PUERTO = 12345; // Puerto en el que el servidor escucha las conexiones
        final int MAX_TAMANO_MENSAJE = 1024; // Tamaño máximo del mensaje

        // Lista para almacenar las direcciones IP de los clientes
        List<InetAddress> clientesConectados = new ArrayList<>();
        List<Integer> clientesPuertos = new ArrayList<>();

        try {
            DatagramSocket socket = new DatagramSocket(PUERTO); // Crear un socket para escuchar conexiones entrantes

            System.out.println("Servidor en línea. Esperando clientes...");

            while (true) {
                byte[] receiveData = new byte[MAX_TAMANO_MENSAJE];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                socket.receive(receivePacket); // Recibir un paquete de datos entrante

                String mensajeRecibido = new String(receivePacket.getData(), 0, receivePacket.getLength()); // Convertir los datos en un mensaje
                InetAddress clientAddress = receivePacket.getAddress(); // Dirección IP del cliente
                int clientPort = receivePacket.getPort(); // Puerto del cliente

                // Verificar si el cliente está conectado, si no, agregarlo a la lista de clientes
                if (!clientesConectados.contains(clientAddress)) {
                    clientesConectados.add(clientAddress);
                    clientesPuertos.add(clientPort);

                    // Mostrar la lista de clientes conectados
                    System.out.println("Clientes conectados:");
                    for (int i = 0; i < clientesConectados.size(); i++) {
                        System.out.println(clientesConectados.get(i) + ":" + clientesPuertos.get(i));
                    }
                }

                System.out.println("Mensaje recibido del cliente: " + mensajeRecibido);

                // Enviar el mensaje a todos los clientes conectados (excepto al remitente)
                enviarMensajeAClientes(socket, mensajeRecibido, clientAddress, clientPort, clientesConectados, clientesPuertos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void enviarMensajeAClientes(
        DatagramSocket socket, String mensaje, InetAddress senderAddress, int senderPort, List<InetAddress> clientesConectados, List<Integer> clientesPuertos) {
        try {
            byte[] sendData = mensaje.getBytes();

            // Recorrer la lista de clientes y enviar el mensaje a cada uno de ellos
            for (int i = 0; i < clientesConectados.size(); i++) {
                InetAddress clientAddress = clientesConectados.get(i);
                int clientPort = clientesPuertos.get(i);

                // Evitar el envío del mensaje al remitente original
                if (!(clientAddress.equals(senderAddress) && clientPort == senderPort)) {
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                    socket.send(sendPacket);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
