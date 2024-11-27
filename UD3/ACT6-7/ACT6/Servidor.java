// Servidor.java

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        DataInputStream in = null;
        DataOutputStream out = null;

        try {
            // Display initial status message
            System.out.println("Esperando al cliente.....");

            // Create a server socket and listen on port 6010
            serverSocket = new ServerSocket(6010);
            clientSocket = serverSocket.accept();  // Accept client connection
            
            // Create input and output streams for the connection
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());
            
            // Read the number sent by the client
            int number = in.readInt();
            
            // Calculate the square of the number
            int squaredNumber = number * number;
            
            // Send the result back to the client
            out.writeUTF("El cuadrado del número " + number + " es " + squaredNumber);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) out.close();
                if (in != null) in.close();
                if (clientSocket != null) clientSocket.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

