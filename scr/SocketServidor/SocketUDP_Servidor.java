package scr.SocketServidor;

import java.io.*;
import java.net.*;

public class SocketUDP_Servidor {
    public static void main(String[] args) {
        final int PUERTO = 12345;

        try {
            // Creamos un socket UDP en el puerto especificado
            DatagramSocket socket = new DatagramSocket(PUERTO);

            while (true) {
                // Preparamos un buffer para recibir los datos del cliente
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                // Esperamos a recibir un paquete de datos del cliente
                socket.receive(receivePacket);
                
                // Convertimos los datos recibidos en un mensaje de texto
                String mensajeRecibido = new String(receivePacket.getData(), 0, receivePacket.getLength());

                // Obtenemos la dirección IP y el puerto del cliente que envió el mensaje
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                // Mostramos el mensaje recibido en la consola del servidor
                System.out.println("Mensaje recibido del cliente: " + mensajeRecibido);

                // Reenviamos el mensaje al Cliente2 (este es solo un ejemplo, debes tener lógica para determinar a qué cliente reenviarlo)
                String mensajeAEnviar = "Mensaje del Cliente1 al Cliente2: " + mensajeRecibido;
                byte[] sendData = mensajeAEnviar.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);

                socket.send(sendPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
