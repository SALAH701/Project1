import java.util.*;

class Consumer implements Runnable {
   private List<Integer> sharedQueue;
public Consumer(List<Integer> sharedQueue) {
    this.sharedQueue = sharedQueue;
}

   @Override
public void run() {
    while (true) {
        try {
            consume();
            Thread.sleep(1000);
        } catch (InterruptedException e) {  e.printStackTrace(); }
    }
}

private void consume() throws InterruptedException {
  
   synchronized (sharedQueue) {
      //if Queue is empty wait until producer produces.
      while (sharedQueue.size() == 0) {
          System.out.println("Queue is empty, consumerThread is waiting for producerThread to produce, Queue size= 0");
            sharedQueue.wait();
        }

      Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName()+", CONSUMED : "+ sharedQueue.remove(0));
        sharedQueue.notify();
    }
}

}

