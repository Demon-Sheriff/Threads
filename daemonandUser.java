
public class daemonandUser {
    public static void main(String[] args) {
        
        Thread bg = new Thread(new DaemonThread());
        Thread user = new Thread(new UserThread());
        bg.setDaemon(true);
        bg.start();
        user.start();

    }
}

class DaemonThread implements Runnable {

    @Override
    public void run(){

        int c = 0;
        while(c < 50){
            try{
                Thread.sleep(1000);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
            c++;
            System.out.println("daemon thread is running");
        }
    }
}

class UserThread implements Runnable{

    @Override
    public void run(){
        try{
            Thread.sleep(5000);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("user thread is running");
    }
}
