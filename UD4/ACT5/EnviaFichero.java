import java.io.Serializable;

public class EnviaFichero implements Serializable {

    // Declaración de atributos del fichero a subir al servidor
    byte[] contenidoFichero;
    String nombre;
    String directorio;

    // Constructor
    public EnviaFichero(byte[] contenidoFichero, String nombre, String directorio) {
        this.contenidoFichero = contenidoFichero;
        this.nombre = nombre;
        this.directorio = directorio;
    }

    // Método para obetener el contenido del fichero
    public byte[] getContenidoFichero() {
        return contenidoFichero;
    }

    // Método para obtener el nombre del fichero
    public String getNombre() {
        return nombre;
    }

    // Método para obtener el directorio del ficherp
    public String getDirectorio() {
        return directorio;
    }
}
