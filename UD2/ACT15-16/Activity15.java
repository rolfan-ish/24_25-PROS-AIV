import java.time.LocalTime;

public class Activity15 {
    public static void main(String[] args) {
        // Create and start three threads
        for (int i = 1; i <= 3; i++) {
            new Thread(new MessageThread("Hilo " + i)).start();
        }
    }
}

class MessageThread implements Runnable {
    private final String threadName;

    public MessageThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(threadName + " - " + LocalTime.now());
            try {
                Thread.sleep(1000); // Wait 1 second between messages
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
            }
        }
    }
}

