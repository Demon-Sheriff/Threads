import java.util.concurrent.Semaphore;

class SharedResource {
    private int value = 0;

    // Semaphore with one permit, acting as a binary semaphore
    private final Semaphore semaphore = new Semaphore(1);

    public void increment() {
        try {
            semaphore.acquire();
            value++;
            System.out.println("Incremented value: " + value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    public void decrement() {
        try {
            semaphore.acquire();
            value--;
            System.out.println("Decremented value: " + value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    public int getValue() {
        return value;
    }
}

public class SemaphoreExample {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread incrementThread1 = new Thread(sharedResource::increment);
        Thread incrementThread2 = new Thread(sharedResource::increment);
        incrementThread1.start();
        incrementThread2.start();

        Thread decrementThread1 = new Thread(sharedResource::decrement);
        Thread decrementThread2 = new Thread(sharedResource::decrement);
        decrementThread1.start();
        decrementThread2.start();

        try {
            incrementThread1.join();
            incrementThread2.join();
            decrementThread1.join();
            decrementThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final value: " + sharedResource.getValue());
    }
}
