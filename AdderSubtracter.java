public class AdderSubtracter {
    public static void main(String[] args) throws InterruptedException {
        
        Value val = new Value(0);
        Adder add = new Adder(val);
        Subtracter sub = new Subtracter(val);

        Thread addthread = new Thread(add);
        Thread subthread = new Thread(sub);

        addthread.start();
        subthread.start();
        addthread.join();
        subthread.join();

        System.out.println(val.getVal());

    }
}

class Value{

    int val;

    public Value(int v){
        val = v;
    }

    public synchronized int getVal() {
        return val;
    }

    public synchronized void setVal(int val) {
        this.val = val;
    }
}


class Adder implements Runnable{

    Value v;

    public Adder(Value val){
        v = val;
    }

    @Override
    public void run(){

        for (int i = 0; i <= 10000; i++) {
            synchronized (v) {
                v.setVal(v.getVal() + i);
            }
        }
    }
}

class Subtracter implements Runnable{

    Value v;

    public Subtracter(Value val){
        v = val;
    }


    @Override
    public void run(){
        
        for (int i = 0; i <= 10000; i++) {
            synchronized (v) {
                v.setVal(v.getVal() - i);
            }
        }
    }
}

