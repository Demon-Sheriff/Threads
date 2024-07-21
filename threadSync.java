public class threadSync {

    static int count = 0;

    static synchronized void increment(){/* This is the critical section. */
        count++; 
    }
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting threads...");

        Thread tempOne = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                increment();
            }
            System.out.println("Thread one finished");
        });

        Thread tempTwo = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                increment();
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
