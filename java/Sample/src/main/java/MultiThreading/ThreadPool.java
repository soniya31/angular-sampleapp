package MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool  {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        for(int i=0;i<10;i++){
            Runnable worker = new WorkerThread();
            es.execute(worker);

        }
        es.shutdown();
        while (!es.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}
