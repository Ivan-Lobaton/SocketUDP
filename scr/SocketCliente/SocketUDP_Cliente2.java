package scr.SocketCliente;

import java.io.*;
import java.net.*;

public class SocketUDP_Cliente2 {
    public static void main(String[] args) {
        final String SERVIDOR_IP = "localhost"; // Dirección IP del servidor
        final int SERVIDOR_PUERTO = 12345; // Puerto del servidor

        try {
            DatagramSocket socket = new DatagramSocket(); // Crear un socket UDP para la comunicación

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            // Pedir al usuario que ingrese un nombre
            System.out.print("Ingresa tu nombre: ");
            String nombreCliente = userInput.readLine();

            while (true) {
                System.out.print("Escribe un mensaje: ");
                String mensaje = userInput.readLine();
                String mensajeAEnviar = "[" + nombreCliente + "] " + mensaje; // Agregar el nombre del cliente al mensaje

                byte[] sendData = mensajeAEnviar.getBytes(); // Convertir el mensaje en bytes

                InetAddress serverAddress = InetAddress.getByName(SERVIDOR_IP); // Convertir la dirección IP del servidor

                // Enviar el mensaje al servidor
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, SERVIDOR_PUERTO);
                socket.send(sendPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
