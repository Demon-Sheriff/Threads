public class threadpriority {
    public static void main(String[] args) {
       
        System.out.println(Thread.currentThread().getName() + " is running");
        Thread one = new Thread(() -> {
            System.out.println("one is running");
        });

        one.setPriority(Thread.MAX_PRIORITY);
        one.start();
    }
    
}
