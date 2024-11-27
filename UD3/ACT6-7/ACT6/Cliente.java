// Cliente.java

import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        Socket socket = null;
        DataOutputStream out = null;
        DataInputStream in = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Display initial status message
            System.out.println("PROGRAMA CLIENTE INICIANDO");
            
            // Establish connection with the server
            socket = new Socket("localhost", 6010);
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            
            // Ask for a number from the user
            System.out.println("Introduce un número");
            int number = Integer.parseInt(reader.readLine());
            
            // Send the number to the server
            out.writeInt(number);
            
            // Receive and display the squared number from the server
            String message = in.readUTF();
            System.out.println("Recibiendo mensaje del servidor: ");
            System.out.println("\t" + message);
        } catch (IOException e) {
            e.printStackTrace();
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

