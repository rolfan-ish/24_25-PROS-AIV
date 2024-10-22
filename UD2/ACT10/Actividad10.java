public class Actividad10 {
    public static void main(String[] args) {
        // Displaying main thread information
        Thread mainThread = Thread.currentThread();
        System.out.println("Nombre del thread: " + mainThread.getName() + " y su prioridad es: " + mainThread.getPriority());

        // Creating instances of Hilo class with different messages
        Hilo hilo1 = new Hilo("Hilo-prioridad 3");
        Hilo hilo2 = new Hilo("Hilo-prioridad 7");

        // Setting priorities
        hilo1.setPriority(3);
        hilo2.setPriority(7);

        // Displaying thread information
        System.out.println(hilo1.getName() + " tiene la prioridad " + hilo1.getPriority());
        System.out.println(hilo2.getName() + " tiene la prioridad " + hilo2.getPriority());

        // Starting threads in the specified order
        hilo1.start();
        hilo2.start();
        System.out.println("Final programa");
    }
}
