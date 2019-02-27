package buisness;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Consumer implements Runnable{

    protected ConcurrentLinkedQueue<String> queue;

    public Consumer(ConcurrentLinkedQueue<String> queue){
        this.queue = queue;
    }

    public void run() {
        String str;
        System.out.println("Consumer Started");
        for (int x = 0; x < 10; x++) {
            while ((str = queue.poll()) != null) {
                System.out.println("Removed: " + str);
            }
            try {
                Thread.currentThread().sleep(500);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
