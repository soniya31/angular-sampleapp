package MultiThreading;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.Executors;

public class MyRunnable implements Runnable
{
  static int i =29;

    @Override
    public void run() {
        if (Thread.currentThread().getName() == "thread1")
            method3_Synch_Block();
        else {
           // method2();
            try {
                Thread.sleep(4000);
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
            method1_Static();
        }
    }


     synchronized void  method1_Static(){
        System.out.println("method!_Static"+Thread.currentThread().getName());
        try {
            i++;
            System.out.println("method!_Static"+Thread.currentThread().getName()+ i);

            Thread.sleep(2000);
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }

    }

    static void method2(){
        System.out.println("Method2"+Thread.currentThread().getName());
        try {
            i++;
            System.out.println("method!_Static"+Thread.currentThread().getName()+ i);

            Thread.sleep(2000);
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        System.out.println("leaving");
     }


       void method3_Synch_Block()  {

       synchronized (MyRunnable.class){
            System.out.println("Sync_block"+Thread.currentThread().getName());
     try {
         Thread.sleep(10000);
     } catch ( InterruptedException e ) {
         e.printStackTrace();
     }
            System.out.println("Leaving Sync_block"+Thread.currentThread().getName());
 }
  }

    public static void main(String[] args) {
        MyRunnable runnable =new MyRunnable();
        MyRunnable runnable1 =new MyRunnable();
        Thread thread1 =new Thread(runnable, "thread1");
        Thread thread2 =new Thread(runnable, "thread2");
        Thread thread3 =new Thread(runnable, "thread2");
        thread1.start();
        //thread2.start();
        thread3.start();


       // Executors.
    }
}
