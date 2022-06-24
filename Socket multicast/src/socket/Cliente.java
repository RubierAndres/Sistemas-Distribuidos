package socket;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {

    static String host = "230.0.0.10"; //Direccion IP para multicast
    static int port = 4000; //Puerto

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        int numeroMensaje = 1;
        DatagramSocket socket = new DatagramSocket();
        InetAddress grupo = InetAddress.getByName(host);
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = sc.nextLine();
        System.out.println("Nombre del cliente: " + nombre);
        while (true) {
            String mensajeAux = "El cliente " + nombre + " envia el mensaje: " + numeroMensaje;
            byte[] mensajeByte = mensajeAux.getBytes();
            DatagramPacket packet = new DatagramPacket(mensajeByte, mensajeByte.length, grupo, port);
            socket.send(packet);
            System.out.println("El número de mensajes enviado es: " + numeroMensaje);
            numeroMensaje++;
            Thread.sleep(2000);
        }

    }
}
