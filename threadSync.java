public class threadSync {

    static int count = 0;
    public static void main(String[] args) throws InterruptedException{
        
        Thread one = new Thread(() -> {
            for(int i=0; i<100000; i++){
                System.out.println("one is running");
                ++count; // non atomic operation.
                System.out.println( "count is :" + count );
            }
        });

        Thread two = new Thread(() -> {
            for(int i=0; i<100000; i++){

                System.out.println("two is running");
                ++count;
                System.out.println( "count is :" + count );
            }
        });

        one.start();
        two.start();

        one.join();
        two.join();

        System.out.println("final count is : " + count);
    }
}

