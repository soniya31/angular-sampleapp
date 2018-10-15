package MultiThreading;

public class AtomicThread {


    int counter =0;

    public void increment(){
        counter++;

    }

    public int getCounter() {
        return counter;
    }

    public static void main(String[] args) {

        AtomicThread at =new AtomicThread();
        new Thread(()->{
                 try {
                     for (int i = 0; i < 10; i++) {
                         Thread.sleep(2333);

                     } }catch(InterruptedException e ){
                         e.printStackTrace();
                     }

            System.out.println(Thread.currentThread().getName());
            System.out.println(at.getCounter());

        }).start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
            System.out.println(at.getCounter());
        }).start();

    }


}
