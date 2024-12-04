// Cliente.java

import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket(34567);

            // Create and serialize the Tenista object
            Tenista tenista = new Tenista("del Potro", 198);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(tenista);
            byte[] sendData = baos.toByteArray();

            // Send the object to the server
            InetAddress serverAddress = InetAddress.getByName("localhost");
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 12348);
            clientSocket.send(sendPacket);
            System.out.println("Envío el objeto: " + tenista);

            // Wait for the modified object from the server
            System.out.println("Esperando datagrama.......");
            byte[] buffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
            clientSocket.receive(receivePacket);

            // Deserialize the modified object
            ByteArrayInputStream bais = new ByteArrayInputStream(receivePacket.getData());
            ObjectInputStream ois = new ObjectInputStream(bais);
            Tenista receivedTenista = (Tenista) ois.readObject();
            System.out.println("He recibido el objeto: " + receivedTenista);

            System.out.println("Fin del cliente");
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

