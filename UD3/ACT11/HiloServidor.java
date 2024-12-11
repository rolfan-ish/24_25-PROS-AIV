/**
 * HiloServidor.java
 * A thread class responsible for handling client communication.
 */
import java.io.*;
import java.net.*;

public class HiloServidor extends Thread {
    private Socket clientSocket;

    /**
     * Constructor for HiloServidor.
     * 
     * @param clientSocket the socket connected to the client.
     */
    public HiloServidor(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String received;
            while ((received = input.readLine()) != null) {
                System.out.println("Comunico con: " + clientSocket);
                if ("*".equals(received)) {
                    System.out.println("Fin de la conexión con: " + clientSocket);
		    output.println("*");
                    break;
                }
                output.println(received.toUpperCase());
            }
        } catch (IOException e) {
            System.err.println("Error comunicando con el cliente: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Error cerrando el socket: " + e.getMessage());
            }
        }
    }
}
