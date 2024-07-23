public class seqExecution {
    
    public static void main(String[] args) {
        
        Thread curr = Thread.currentThread();

        System.out.println("curr thread :");
        System.out.println("Name: " + curr.getName());
        System.out.println("Priority : " + curr.getPriority());
        System.out.println("ID : " + curr.threadId());
        System.out.println("state : " + curr.getState());

        Thread one = new Thread(new ThreadOne());
        Thread two = new Thread(new Threadtwo());
        Thread three = new Thread(new Runnable() {
            
            @Override
            public void run(){

                for(int i=0; i<15; i++){
                    System.out.println("Thread three : " + i);
                }
            }
        });

        one.start();
        two.start();
        three.start();
    }
}

class ThreadOne implements Runnable {
    @Override
    public void run(){
        for(int i=0; i<20; i++){
            System.out.println("Thread One : " + i);
        }
    }
}


class Threadtwo implements Runnable {
    @Override
    public void run(){
        for(int i=0; i<15; i++){
            System.out.println("Thread two : " + i);
        }
    }
}
