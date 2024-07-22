public class threadpriority {
    public static void main(String[] args) {
       
        
        Thread one = new Thread(() -> {
            System.out.println("one is running");
        });

        one.setPriority(Thread.MAX_PRIORITY);
        
        System.out.println("priority for one is : " + one.getPriority());
        System.out.println("priority for main thread is : " + Thread.currentThread().getPriority());
        
        one.start();
        
        System.out.println(Thread.currentThread().getName() + " is running");
    }
    
}
