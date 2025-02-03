import java.io.Serializable;

public class PideFichero implements Serializable {
    String nombreFichero;

    public PideFichero(String nombreFichero) {
        this.nombreFichero = nombreFichero;
    }

    public String getNombreFichero() { return nombreFichero; }
}
