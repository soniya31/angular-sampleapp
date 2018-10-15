package MultiThreading;

public class PrintEvenAndOdd
{
    int  count =0;
    boolean odd = false;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static void main(String[] args) {
        PrintEvenAndOdd p =new PrintEvenAndOdd();

        Thread t1 =new Thread(new Runnable() {

            @Override
            public void run() {
                while(!p.odd){
                    try {
                        wait();
                    } catch ( InterruptedException e ) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Thread Number :"+ p.count);
            }
        });

    }

}
