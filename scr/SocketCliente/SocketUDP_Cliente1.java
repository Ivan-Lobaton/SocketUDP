package scr.SocketCliente;

import java.io.*;
import java.net.*;

public class SocketUDP_Cliente1 {
    public static void main(String[] args) {
        final String SERVIDOR_IP = "localhost"; // Dirección IP del servidor
        final int SERVIDOR_PUERTO = 12345; // Puerto del servidor

        try {
            DatagramSocket socket = new DatagramSocket(); // Creamos un socket UDP

            String mensaje = "¡Hola Cliente2!"; // Mensaje que queremos enviar
            byte[] sendData = mensaje.getBytes(); // Convertimos el mensaje en bytes
            InetAddress serverAddress = InetAddress.getByName(SERVIDOR_IP); // Obtenemos la dirección IP del servidor

            // Preparamos un paquete con los datos a enviar
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, SERVIDOR_PUERTO);
            socket.send(sendPacket); // Enviamos el paquete al servidor

            // Preparamos un paquete para recibir la respuesta del servidor
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket); // Esperamos a recibir un paquete del servidor

            // Convertimos los datos recibidos en un mensaje de texto
            String mensajeRecibido = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Mensaje recibido del servidor: " + mensajeRecibido); // Mostramos el mensaje recibido en la consola

            socket.close(); // Cerramos el socket
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
