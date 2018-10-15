package MultiThreading;

import java.text.SimpleDateFormat;

public class ThEadLocalDemo implements Runnable{

    ThreadLocal<SimpleDateFormat> th =new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyMMdd");        }
    };

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(th.get().toPattern());
        if(Thread.currentThread().getName() == "Thread-1")
        th.set(new SimpleDateFormat());
        try {
            Thread.sleep(5500);
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }

        System.out.println("After"+ th.get().toPattern());

    }

    public static void main(String[] args) {
        ThEadLocalDemo d =new ThEadLocalDemo();

        Thread th1 =new Thread(d,"Thread-1");
        Thread th2 =new Thread(d, "Thread-2");
        Thread th3 =new Thread(d,"Thread-3");
        Thread th4 =new Thread(d,"Thread-4");
        th1.start();
        th2.start();
        th3.start();
        th4.start();




    }
}
