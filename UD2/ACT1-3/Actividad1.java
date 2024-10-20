public class Actividad1 {
    public static void main(String[] args) {
        // Create two threads with the string "Primero" and "Segundo", respectively
        Hilo primero = new Hilo("Primero", 20);
        Hilo segundo = new Hilo("Segundo", 20);

        // Start the threads
        primero.start();
        segundo.start();

        // Print "Fin programa" after both threads are started
        System.out.println("Fin programa");
    }
}
