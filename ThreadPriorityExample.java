public class ThreadPriorityExample {
    public static void main(String[] args) {
        // Create a low-priority thread
        Thread lowPriorityThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Low priority thread");
            }
        });
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);

        // Create a high-priority thread
        Thread highPriorityThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("High priority thread");
            }
        });
        highPriorityThread.setPriority(Thread.MAX_PRIORITY);

        // Start both threads
        lowPriorityThread.start();
        highPriorityThread.start();

        // Wait for both threads to finish
        try {
            lowPriorityThread.join();
            highPriorityThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished.");
    }
}
