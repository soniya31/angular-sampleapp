package MultiThreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class Scheduled {
 int a=0;

    public static void main(String[] args) {
        Scheduled s =new Scheduled();

     Runnable r =new Runnable() {

         @Override
         public void run() {
             synchronized (this) {
             try {

                     System.out.println(Thread.currentThread().getName());
                     System.out.println(++s.a);

                     Thread.sleep(2000);
                 } catch(InterruptedException e ){
                     e.printStackTrace();
                 }
             }

             }
         }

         ;

        ScheduledExecutorService es = Executors.newScheduledThreadPool(3);
for(int i=0;i<10;i++)
{
    es.schedule(r,10, TimeUnit.MILLISECONDS);


}
    }
}
