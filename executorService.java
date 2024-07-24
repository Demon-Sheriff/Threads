import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.*;

public class executorService {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ExecutorService es = Executors.newFixedThreadPool(5);

        List<Integer> list = (new ArrayList<>());
        System.out.println("enter 5 integers");

        for(int i=0; i<5; i++){
            es.execute(new Runnable() {
                
                @Override
                public void run(){
                    
                    synchronized(sc){
                        System.out.println("enter an integer: ");
                        int ip = sc.nextInt();
                        int res = ip*2;
    
                        list.add(res);
                    }
                }
            });
        }

        // shutdown the executor
        es.shutdown();
        while (!es.isTerminated()) {
            // waiting for tasks to shutdown
        }

        System.out.println("double list : " + list);
    }

}
