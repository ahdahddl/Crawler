package buisness;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Producer implements Runnable{

    protected ConcurrentLinkedQueue<String> queue;

    public Producer(ConcurrentLinkedQueue<String> queue){
        this.queue = queue;
    }

    public void run() {
        System.out.println("Producer Started");
        try {
            for (int i = 1; i < 10; i++) {
                queue.add("String" + i);
                System.out.println("Added: String" + i);
                Thread.currentThread().sleep(200);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
