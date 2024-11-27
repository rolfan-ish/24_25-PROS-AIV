// Servidor.java

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        DataInputStream in = null;
        DataOutputStream out = null;
        int clientCount = 1;

        try {
            // Display the initial message
            System.out.println("Esperando a los clientes.....");

            // Create a server socket to listen on port 6013
            serverSocket = new ServerSocket(6013);

            while (clientCount <= 3) {
                // Accept client connection
                clientSocket = serverSocket.accept();

                // Create input and output streams for the client connection
                in = new DataInputStream(clientSocket.getInputStream());
                out = new DataOutputStream(clientSocket.getOutputStream());

                // Send a greeting message to the client
                out.writeUTF("Hola cliente " + clientCount);

                // Increment client counter for next client
                clientCount++;

                // Close the streams and socket for this client
                in.close();
                out.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

