public class Actividad2 {
    public static void main(String[] args) {
        // Check if the argument is provided
        if (args.length != 1) {
            System.out.println("Por favor, proporcione el número de hilos como argumento.");
            return;
        }

        // Parse the number of threads from the command-line argument
        int n = Integer.parseInt(args[0]);

        // Create and start 'n' threads
        for (int i = 1; i <= n; i++) {
            int threadNumber = i;

            // Create and start a thread using a lambda expression
            new Thread(() -> {
                for (int j = 1; j <= 20; j++) {
                    System.out.println("Hilo " + threadNumber + " - Iteración " + j);
                }
            }).start();
        }

        // After creating the threads, print "Final Programa"
        System.out.println("Final Programa");
    }
}
