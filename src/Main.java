import worker.FileWorker;

public class Main {


    public static void main(String [] args)
    {
        FileWorker worker = new FileWorker("test", "/home/mongmongi/문서");
        worker.doWork();
    }


}
