import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;

public class Actividad2 {

    public static void main(String[] args) {
        // FTP server details
        String server = "192.168.1.133";
        int port = 21;
        String user = "dinux";
        String pass = "dinux";
        String baseFolder = "aplicacionwebibarra";

        FTPClient ftpClient = new FTPClient();

        try {
            // Display server connection message
            System.out.println("Nos conectamos a " + server);

            // Connect to the server
            ftpClient.connect(server, port);

            // Login to the server
            boolean login = ftpClient.login(user, pass);
            if (login) {
                System.out.println("Login correcto");

                // Display current directory
                System.out.println("Directorio actual: " + ftpClient.printWorkingDirectory());

                // Set FTP mode to passive and binary file type
                ftpClient.enterLocalPassiveMode();
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

                // Create base directory and subdirectories
                boolean baseCreated = ftpClient.makeDirectory(baseFolder);
                boolean htmlCreated = ftpClient.makeDirectory(baseFolder + "/html");
                boolean imagesCreated = ftpClient.makeDirectory(baseFolder + "/imagenes");
                boolean cssCreated = ftpClient.makeDirectory(baseFolder + "/css");

                if (baseCreated && htmlCreated && imagesCreated && cssCreated) {
                    System.out.println("Directorios creados...");
                } else {
                    System.out.println("NO SE HAN PODIDO CREAR LOS DIRECTORIOS");
                }

                // Logout from the server
                if (ftpClient.logout()) {
                    System.out.println("Logout del servidor FTP...");
                } else {
                    System.out.println("Error al hacer logout");
                }

            } else {
                System.out.println("Login incorrecto...");
            }

        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
            ex.printStackTrace();

        } finally {
            try {
                // Disconnect from the server
                if (ftpClient.isConnected()) {
                    ftpClient.disconnect();
                    System.out.println("Desconectado...");
                }
            } catch (IOException ex) {
                System.err.println("Error al desconectar: " + ex.getMessage());
            }
        }
    }
}
