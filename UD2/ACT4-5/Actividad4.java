public class Actividad4 {
    public static void main(String[] args) {
        // Create threads for "Primero" and "Segundo" using the Posicion class
        Thread primeroThread = new Thread(new Posicion("Primero", 15));
        Thread segundoThread = new Thread(new Posicion("Segundo", 15));

        // Start both threads
        primeroThread.start();
        segundoThread.start();

        // Print "Fin programa" after starting the threads
        System.out.println("Fin programa");
    }
}
