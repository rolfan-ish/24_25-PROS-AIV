public class Actividad5 {
    public static void main(String[] args) {
        Primero p = new Primero();
        Segundo s = new Segundo();

        p.start();
        s.start();

        // Print "Fin programa" after starting the threads
        System.out.println("Fin programa");
    }
}
