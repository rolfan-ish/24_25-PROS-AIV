import org.apache.commons.net.ftp.FTPClient;
import java.io.IOException;

/**
 * A Java program that connects to the RedIRIS public FTP server.
 * The program demonstrates login, directory creation, and logout functionality using the FTPClient class.
 * It handles exceptions and ensures proper disconnection from the server.
 */
public class Actividad1 {

    /**
     * The main method that drives the FTP interaction.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        FTPClient ftpClient = new FTPClient();
        String server = "ftp.rediris.es";
        String user = "anonymous";
        String password = "dm2";

        System.out.println("Nos conectamos a " + server);

        try {
            // Connect to the FTP server
            ftpClient.connect(server);

            // Log in to the server
            boolean login = ftpClient.login(user, password);
            if (login) {
                System.out.println("Login correcto");

                // Print the current directory
                String currentDirectory = ftpClient.printWorkingDirectory();
                System.out.println("Directorio actual:" + currentDirectory);

                // Attempt to create the directory
                String newDirectory = "DM2PROS";
                boolean dirCreated = ftpClient.makeDirectory(newDirectory);
                if (dirCreated) {
                    System.out.println("Directorio creado....");
                } else {
                    System.out.println("NO SE HA PODIDO CREAR EL DIRECTORIO");

                    /**
                     * Problem encountered: The FTP server may not allow directory creation due to permissions.
                     * Solution: Check the server's capabilities or try creating the directory in a writable subdirectory.
                     * Example (hypothetical):
                     * ftpClient.changeWorkingDirectory("/writable-directory");
                     * boolean dirCreated = ftpClient.makeDirectory(newDirectory);
                     */
                }

                // Log out of the server
                boolean logout = ftpClient.logout();
                if (logout) {
                    System.out.println("Logout del servidor FTP...");
                } else {
                    System.out.println("Error al hacer logout...");
                }
            } else {
                System.out.println("Login incorrecto...");
            }
        } catch (IOException e) {
            // Handle IO exceptions during FTP operations
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Ensure the FTP client disconnects properly
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.disconnect();
                    System.out.println("Desconectado...");
                }
            } catch (IOException ex) {
                System.err.println("Error al desconectar: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}
