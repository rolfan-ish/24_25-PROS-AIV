public class Hilo extends Thread {
    private String name;
    private int repetitions;

    // Constructor that accepts the string and number of repetitions
    public Hilo(String name, int repetitions) {
        this.name = name;
        this.repetitions = repetitions;
    }

    // Run method to print the string the specified number of times
    public void run() {
        for (int i = 1; i <= repetitions; i++) {
            System.out.println(name + " " + i);
        }
    }
}
