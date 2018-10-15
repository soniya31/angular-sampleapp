package MultiThreading;

public class Demo implements Runnable {

    volatile int count =0;


    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName());
            count++;
            Thread.sleep(300);

            System.out.println(Thread.currentThread().getName()+ count);
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<Integer> threadLocal =new ThreadLocal<>();
        threadLocal.set(12);
        Demo demo =new Demo();
        Thread t1 =new Thread(demo);
        t1.start();
        Thread t2 =new Thread(demo);
        t2.start();

        t2.join();
        t1.join();
        System.out.println(Thread.currentThread().getName());
    }
}
