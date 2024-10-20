public class Posicion implements Runnable {
    private String name;
    private int repetitions;

    // Constructor to set the name and number of repetitions
    public Posicion(String name, int repetitions) {
        this.name = name;
        this.repetitions = repetitions;
    }

    // Run method to print the name 'repetitions' times
    public void run() {
        for (int i = 1; i <= repetitions; i++) {
            System.out.println(name + " " + i);
        }
    }
}
