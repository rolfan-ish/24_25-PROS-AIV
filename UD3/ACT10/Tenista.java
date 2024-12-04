// Tenista.java

import java.io.Serializable;

public class Tenista implements Serializable {
    private String apellido;
    private int altura;

    public Tenista(String apellido, int altura) {
        this.apellido = apellido;
        this.altura = altura;
    }

    public String getApellido() {
        return apellido;
    }

    public int getAltura() {
        return altura;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return apellido + " " + altura;
    }
}

