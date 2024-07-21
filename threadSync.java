import java.util.concurrent.atomic.AtomicInteger;

public class threadSync {

    static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting threads...");

        Thread tempOne = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                count.incrementAndGet();
            }
            System.out.println("Thread one finished");
        });

        Thread tempTwo = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                count.incrementAndGet();
            }
            System.out.println("Thread two finished");
        });

        tempOne.start();
        tempTwo.start();

        tempOne.join();
        tempTwo.join();

        System.out.println("Both threads finished");
        System.out.println("Final count is : " + count);
    }
}
