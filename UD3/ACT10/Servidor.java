// Servidor.java

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(12348);
            byte[] buffer = new byte[1024];

            System.out.println("Esperando datagrama.......");
            DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
            serverSocket.receive(receivePacket);

            // Deserialize received object
            ByteArrayInputStream bais = new ByteArrayInputStream(receivePacket.getData());
            ObjectInputStream ois = new ObjectInputStream(bais);
            Tenista tenista = (Tenista) ois.readObject();
            System.out.println("Recibo el objeto: " + tenista);

            System.out.println("IP de origen: " + receivePacket.getAddress());
            System.out.println("Puerto de origen: " + receivePacket.getPort());

            // Modify the object
            tenista.setApellido("Karlovic");
            tenista.setAltura(208);

            // Serialize the modified object
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(tenista);
            byte[] sendData = baos.toByteArray();

            // Send modified object back to client
            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            serverSocket.send(sendPacket);

            System.out.println("Envío el objeto: " + tenista);
            System.out.println("Fin del servidor");

            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

