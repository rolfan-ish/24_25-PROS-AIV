class Primero extends Thread {
    public void run() {
        for (int i = 1; i <= 15; i++) {
            System.out.println("Primero " + i);

            // Pause the thread for 100 milliseconds (0.1 seconds)
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Hilo Primero interrumpido");
            }
        }
    }
}
