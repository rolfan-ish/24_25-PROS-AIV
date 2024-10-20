public class Actividad3 {
    public static void main(String[] args) {
        // Create a new thread
        Hilo hilo = new Hilo();
        
        // Display the initial name and priority using getName() and getPriority()
        System.out.println("El nombre del hilo es " + hilo.getName() + " y tiene la prioridad " + hilo.getPriority());

        // Change the name and priority of the thread
        hilo.setName("SUPER-HILO-DM2");
        hilo.setPriority(6);

        // Display the new name and priority
        System.out.println("Ahora el nombre del hilo es " + hilo.getName() + " y tiene la prioridad " + hilo.getPriority());

        // Start the thread
        hilo.start();

        // Print final message
        System.out.println("Final programa");
    }
}

class Hilo extends Thread {
    // Run method to perform the thread's task
    public void run() {
        // Thread could perform any task here if needed
    }
}
