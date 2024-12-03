// Servidor.java
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(12346); // Port to listen on
            System.out.println("Esperando datagrama...");
            
            // Prepare to receive a datagram
            byte[] receiveData = new byte[1];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            
            // Extract the number sent by the client
            byte number = receivePacket.getData()[0];
            System.out.println("Vamos a calcular el cubo de: " + number);
            
            // Get client information
            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();
            System.out.println("IP de origen: " + clientAddress);
            System.out.println("Puerto de origen: " + clientPort);
            
            // Calculate the cube of the number
            int cube = number * number * number;
            
            // Send the result back to the client
            byte[] sendData = java.nio.ByteBuffer.allocate(4).putInt(cube).array();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            socket.send(sendPacket);
            System.out.println("Enviamos el resultado..." + cube);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                System.out.println("Adiósss");
                socket.close();
            }
        }
    }
}

