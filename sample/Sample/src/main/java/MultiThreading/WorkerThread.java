package MultiThreading;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.sound.midi.Soundbank;

public class WorkerThread implements Runnable {

    int a =10;
    @Override
    public void run() {
        try {

            System.out.println("Thread Name:"+ Thread.currentThread().getName());

            Thread.sleep(500);
            System.out.println("Value of a is :" + a);
            ++a;
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        System.out.println("Bye Bye From :"+ Thread.currentThread().getName());
    }
}
