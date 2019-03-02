package filesystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TargetFileProcessor implements Runnable{

    protected ConcurrentLinkedQueue<String> queue;

    public TargetFileProcessor(ConcurrentLinkedQueue<String> queue){
        this.queue = queue;
    }

    public boolean isFilelocked(File file) {
        try {
            try (FileInputStream in = new FileInputStream(file)) {
                in.read();
                in.close();
                return false;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return file.exists();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return true;
        }
    }

    public void run(){
        System.out.println("Consumer Started");
        String str;

        while (true) {
            if ((str = queue.poll()) != null) {
                File file = new File(str);
                if(file.delete()){
                    System.out.println("Removed: " + str);
                }else{
                    System.out.println("Not Removed: " + str);
                }
//                if(!isFilelocked(file)){
//
//
//                }else{
//
//                }
            }

        }
    }
}
