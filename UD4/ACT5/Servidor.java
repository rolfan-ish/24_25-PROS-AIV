import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    static Integer PUERTO = 44441;
    static public EstructuraFicheros NF;
    static ServerSocket servidor;

    public static void main(String[] args) throws IOException {
        String Directorio = "";
        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        f.setDialogTitle("Selecciona el directorio donde están los ficheros");
        int returnVal = f.showDialog(f, "Seleccionar");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = f.getSelectedFile();
            Directorio = file.getAbsolutePath();
        }

        servidor = new ServerSocket(PUERTO);
        System.out.println("Servidor iniciado en el puerto " + PUERTO);
        while (true) {
            Socket cliente = servidor.accept();
            System.out.println("Bienvenido al cliente");
            NF = new EstructuraFicheros(Directorio);
            HiloServidor hilo = new HiloServidor(cliente, NF);
            hilo.start();
        }
    }
}
