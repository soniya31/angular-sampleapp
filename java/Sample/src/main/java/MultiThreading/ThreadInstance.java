package MultiThreading;

public class ThreadInstance implements Runnable {

    int counter=0;

    public static void main(String[] args) {
        ThreadInstance instance1 = new ThreadInstance();
        ThreadInstance instance2 = new ThreadInstance();
        Thread thread1 = new Thread(instance1);
        Thread thread2 = new Thread(instance2);
        thread1.start();
        thread2.start();





    }

  synchronized   public  void getCounter() {
       System.out.println(Thread.currentThread().getName());

        for (int i = 0; i < 5; i++) {
            System.out.println("i" + i);
            try {

              Thread.sleep(200);

            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }


            System.out.println(counter);


        }
        System.out.println(" Ending");

    }

    @Override
    public void run() {
getCounter();

    }
}
