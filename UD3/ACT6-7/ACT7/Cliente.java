// Cliente.java

import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        Socket socket = null;
        DataInputStream in = null;
        DataOutputStream out = null;

        try {
            // Display the initial message
            System.out.println("PROGRAMA CLIENTE INICIANDO");

            // Attempt to connect to the server on port 6013
            socket = new Socket("localhost", 6013);

            // Create input and output streams
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());

            // Read the greeting message from the server
            String message = in.readUTF();

            // Display the message received from the server
            System.out.println("Recibiendo mensaje del servidor: ");
            System.out.println("\t" + message);
        } catch (IOException e) {
            // Handle exception for connection failure (after 3 clients have connected)
            System.out.println("Connection refused: connect");
        } finally {
            try {
                if (out != null) out.close();
                if (in != null) in.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

