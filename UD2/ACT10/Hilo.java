public class Hilo extends Thread {
    private String message;

    // Constructor to accept message
    public Hilo(String message) {
        this.message = message;
    }

    // Overriding the run method
    @Override
    public void run() {
        System.out.println("Ejecutando " + message);
    }
}
