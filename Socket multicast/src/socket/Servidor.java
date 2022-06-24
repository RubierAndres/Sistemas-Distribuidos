package socket;

import java.io.*;
import java.net.*;

public class Servidor {

    static String host = "230.0.0.10"; //Direccion IP para multicast
    static int port = 4000; //Puerto

    public static void main(String args[]) throws IOException, ClassNotFoundException {
        InetAddress direccion = InetAddress.getByName(host);
        MulticastSocket socketMulticast = new MulticastSocket(port);
        byte[] buffer = new byte[512];
        socketMulticast.joinGroup(direccion);
        System.out.println("Esperando al cliente...");
        while (true) {
            DatagramPacket mensajePacket = new DatagramPacket(buffer, buffer.length);
            socketMulticast.receive(mensajePacket);
            String mensajeRecibido = new String(mensajePacket.getData(), mensajePacket.getOffset(), mensajePacket.getLength());
            System.out.println(mensajeRecibido);
        }
    }
}
