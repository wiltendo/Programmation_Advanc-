package TP3_VBlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public  class Boulangerie {


    private BlockingQueue<Pain> queue =  new ArrayBlockingQueue<Pain>(20) ;

    public  boolean depose(Pain pain)  throws InterruptedException {
        return queue.offer(pain,  200, TimeUnit.MILLISECONDS) ;
    }

    public Pain achete ()  throws InterruptedException {
        return queue.poll(200, TimeUnit.MILLISECONDS) ;
    }

    public  int getStock() {
        return queue.size() ;
    }
    public  void deposePainEmpoisonne() {
        queue.add(Pain.PAIN_EMPOISONNE) ;
    }
}
