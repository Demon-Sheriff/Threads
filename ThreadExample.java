import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadExample {

    public static class Subtracter {
        private int result;
        private final Lock lock = new ReentrantLock();

        public Subtracter() {
            this.result = 0;
        }

        public void subtract(int value) {
            lock.lock();
            try {
                result -= value;
            } finally {
                lock.unlock();
            }
        }

        public int getResult() {
            lock.lock();
            try {
                return result;
            } finally {
                lock.unlock();
            }
        }
    }

    public static class Adder {
        private int result;
        private final Lock lock = new ReentrantLock();

        public Adder() {
            this.result = 0;
        }

        public void add(int value) {
            lock.lock();
            try {
                result += value;
            } finally {
                lock.unlock();
            }
        }

        public int getResult() {
            lock.lock();
            try {
                return result;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {

        Adder adder = new Adder();
        Subtracter subtracter = new Subtracter();
        List<Thread> threads = new ArrayList<>();

        // Create threads for addition
        for (int i = 0; i < 10; ++i) {
            int value = i + 1;
            threads.add(new Thread(() -> adder.add(value)));
        }

        // Create threads for subtraction
        for (int i = 0; i < 10; ++i) {
            int value = i + 1;
            threads.add(new Thread(() -> subtracter.subtract(value)));
        }

        // Start threads
        for (Thread thread : threads) {
            thread.start();
        }

        // Join threads
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Final Addition Result: " + adder.getResult());
        System.out.println("Final Subtraction Result: " + subtracter.getResult());
    }
}
