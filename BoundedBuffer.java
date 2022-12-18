import java.util.*;

public class BoundedBuffer {
    public static void main(String args[]) {
        List<Integer> sharedQueue = new LinkedList<Integer>(); //Creating shared object
         
        Producer producer0=new Producer(sharedQueue);
        Consumer consumer0=new Consumer(sharedQueue);
      
           Thread producerThread0 = new Thread(producer0, "Producer1 ");
           Thread consumerThread0 = new Thread(consumer0, "Consumer1 ");
           producerThread0.start();
           consumerThread0.start();
           
           System.out.println("MID");
           
        Producer producer1=new Producer(sharedQueue);
        Consumer consumer1=new Consumer(sharedQueue);
      
           Thread producerThread1 = new Thread(producer1, "Producer2 ");
           Thread consumerThread1 = new Thread(consumer1, "Consumer2 ");
           producerThread1.start();
           consumerThread1.start();
       }
      
}
