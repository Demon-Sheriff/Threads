public class threadSync {

    static int count = 0;

    // create a custom lock
    static Object lock = new Object();

    // block level synchronisation.
    static void increment(){
        synchronized(lock){
            count++;
        }
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
