public class threadpriority {
    public static void main(String[] args) {
       
        System.out.println(Thread.currentThread().getName() + " is running");
        Thread one = new Thread(() -> {
            System.out.println("one is running");
        });

        System.out.println("priority for one is : " + one.getPriority());
        System.out.println("priority for main thread is : " + Thread.currentThread().getPriority());
        one.setPriority(Thread.MAX_PRIORITY);
        one.start();
    }
    
}
