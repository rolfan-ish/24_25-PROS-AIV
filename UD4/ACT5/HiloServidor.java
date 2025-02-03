import java.io.*;
import java.net.Socket;

public class HiloServidor extends Thread {
    Socket socket;
    ObjectOutputStream outObjeto;
    ObjectInputStream inObjeto;
    EstructuraFicheros NF;

    public HiloServidor(Socket s, EstructuraFicheros nF) throws IOException {
        socket = s;
        NF = nF;
        inObjeto = new ObjectInputStream(socket.getInputStream());
        outObjeto = new ObjectOutputStream(socket.getOutputStream());
    }

    public void run() {
        try {
            outObjeto.writeObject(NF);
            while (true) {
                System.out.println("EEEEEEEnviado");
                Object peticion;
                try {
                    peticion = inObjeto.readObject();
                    if (peticion instanceof PideFichero fichero) {
                        EnviaFichero(fichero);
                    }

                    if (peticion instanceof EnviaFichero fic) {
                        // El cliente envía un fichero al servidor para cargarlo
                        File d = new File(fic.getDirectorio());
                        File f1 = new File(d, fic.getNombre());
                        // Creación del fichero en el directorio,
                        // con los bytes enviados en el objeto
                        FileOutputStream fos = new FileOutputStream(f1);
                        fos.write(fic.getContenidoFichero());
                        fos.close();
                        // Creación de la nueva estructura de directorios
                        EstructuraFicheros n = new EstructuraFicheros(fic.getDirectorio());
                        outObjeto.writeObject(n); // Se envía al cliente
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    inObjeto.close();
                    outObjeto.close();
                    socket.close();
                    System.out.println("Cerrando cliente");
                }
            } // while
        } catch (IOException e1) {
            // Cuando un cliente cierra la conexión
        }
    } // Fin run

    // Método que envía al cliente el fichero solicitado
    private void EnviaFichero(PideFichero fich) {
        try {
            File fichero = new File(fich.getNombreFichero());
            FileInputStream filein = null;
            filein = new FileInputStream(fichero);
            long bytes = fichero.length();
            byte[] buff = new byte[(int) bytes];
            int i, j = 0;
            // Lectura del fichero y llenado del array
            try {
                while ((i = filein.read()) != -1) { // Lectura de bytes
                    buff[j] = (byte) i;
                    j++;
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                filein.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            Object ff = new ObtieneFichero(buff);
            try {
                outObjeto.writeObject(ff);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
