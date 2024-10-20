class Segundo extends Thread {
    public void run() {
        for (int i = 1; i <= 15; i++) {
            System.out.println("Segundo " + i);

            // Pause the thread for 200 milliseconds (0.2 seconds)
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("Hilo Segundo interrumpido");
            }
        }
    }
}
