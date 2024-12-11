/**
 * Servidor.java
 * The main server class responsible for listening to client connection requests.
 */
import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(6000)) {
            System.out.println("Servidor iniciado en el puerto 6000");
            while (true) {
                System.out.println("Esperando clientes...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente Conectado.....");
                new HiloServidor(clientSocket).start();
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}
