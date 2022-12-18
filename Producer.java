import java.util.List;


class Producer implements Runnable {

 private List<Integer> sharedQueue;
 private int maxSize = 4; //Queue szie
 int productionSize = 5; //Total no of items to be produced by each producer
 

 public Producer(List<Integer> sharedQueue) {
     this.sharedQueue = sharedQueue;
     
 }

 @Override
 public void run() {
     for (int i = 1; i <= productionSize; i++) { //produce products.
         try {
             produce(i);
         } catch (InterruptedException e) {  e.printStackTrace(); }
     }
}

 private void produce(int i) throws InterruptedException {
  
    synchronized (sharedQueue) {
       //if Queue is full wait until consumer consumes.
       while (sharedQueue.size() == maxSize) {
             System.out.println("Queue is full, producerThread is waiting for consumerThread to consume, Queue size = "+maxSize);
             sharedQueue.wait();
         }
      int min = 0;
      int max = 10;
      int producedItem = (int) Math.floor(Math.random()*(max-min+1)+min);  
      
       sharedQueue.add(producedItem);
       System.out.println(Thread.currentThread().getName() +" Produced : " + producedItem);
         Thread.sleep(2000);
         sharedQueue.notify();
     }
 }
}

