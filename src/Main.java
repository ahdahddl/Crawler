import buisness.Consumer;
import buisness.Producer;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {


    public static void main(String [] args)
    {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();
        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));
        producer.start();
        consumer.start();
    }
}
