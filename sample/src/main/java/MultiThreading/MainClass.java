
package MultiThreading;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {

        Obj obj1 =new Obj();
Runnable r =new Runnable() {
    @Override
    public void run() {
        obj1.executeOne();
    }
};
        Runnable r1 =new Runnable() {
            @Override
            public void run() {

                 obj1.executeTwo();


            }
        };
        Runnable r2 = () -> {

        };

        Thread th1 =new Thread(r);
        th1.start();
        Thread th2 =new Thread(r1);
        th2.start();



       // obj2.execute();
       // obj1.execute();
    }
}

class Obj {

    boolean odd = false;
    int a =0;
    int b =2;
  void execute() throws InterruptedException {
      synchronized (this) {
          System.out.println(Thread.currentThread().getName());
          b++;
          Thread.sleep(4000);
          a++;
          System.out.println(a + b);
          System.out.println(Thread.currentThread().getName() + "Bye!!!!");
      }
  }

  void executeOne() {
      synchronized (this) {
          while (this.a <= 10) {
              while (this.odd) {
                  try {
                      wait();
                  } catch ( InterruptedException e ) {
                      e.printStackTrace();
                  }

              }
              System.out.println(Thread.currentThread().getName() + this.a);
              this.a++;
              this.odd = true;
              notify();
          }
      }
  }
  void executeTwo() {
      synchronized (this) {
          while (this.a <= 10) {
              while (!this.odd) {
                  try {
                      Thread.sleep(4000);
                      wait();
                  } catch ( InterruptedException e ) {
                      e.printStackTrace();
                  }

              }
              System.out.println("Even " + Thread.currentThread().getName() + this.a);
              this.a++;
              this.odd = false;
              notify();
          }
      }
  }
}