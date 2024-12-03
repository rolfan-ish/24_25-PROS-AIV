// Cliente.java

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            byte numberToSend = 4; // Defined within the program (-128 to +127 range)
            socket = new DatagramSocket(34568); // Local port for the client

            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 12346;

            // Prepare the number to send
            byte[] sendData = new byte[1];
            sendData[0] = numberToSend;

            // Send the datagram
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
            socket.send(sendPacket);
            System.out.println("Esperando respuesta...");

            // Prepare to receive the response
            byte[] receiveData = new byte[4]; // For a 32-bit integer response
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);

            // Decode the response
            int result = java.nio.ByteBuffer.wrap(receivePacket.getData()).getInt();
            System.out.println("Esperando respuesta...: el cubo de " + numberToSend + " es " + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                System.out.println("Adiós…");
                socket.close();
            }
        }
    }
}

