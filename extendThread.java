public class extendThread {
    public static void main(String[] args) throws InterruptedException{
        
        Thread one = new Thread1();
        Thread two = new Thread2();

        one.start();
        two.start();
        
        one.join(); // make sure that one is done executing.
        two.join(); // make sure that two is done executing.

        // check the output

        System.out.println("all threads done executing ? or not !? ");

    }
}

class Thread1 extends Thread {

    @Override
    public void run(){
        for(int i=0; i<10; i++){
            System.out.println(
                "thread1 : " + i
            );
        }
    }
}

class Thread2 extends Thread{

    @Override
    public void run(){
        for(int i=0; i<20; i++){
            System.out.println(
                "thread2 : " + i
            );
        }
    }
}
