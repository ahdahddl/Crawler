package worker;

import filesystem.TargetDirectoryWatcher;
import filesystem.TargetFileProcessor;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FileWorker {


    private String workerName = "";

    private String workerPath = "";

    private Path path = null;

    private ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();

    public FileWorker(String workerName, String workerPath){
        this.workerName = workerName;
        this.workerPath = workerPath;
    }

    public void doWork(){

        path = Paths.get(this.workerPath);
        TargetDirectoryWatcher producer = null;
        try {
            producer = new TargetDirectoryWatcher(this.queue);
            producer.walkAndRegisterDirectories(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread threadProducer = new Thread(producer);

        TargetFileProcessor consumer = new TargetFileProcessor(this.queue);
        Thread threadConsumer = new Thread(consumer);

        threadProducer.start();
        threadConsumer.start();
    }


}
