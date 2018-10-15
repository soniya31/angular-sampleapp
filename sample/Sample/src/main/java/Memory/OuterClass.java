package Memory;

import org.apache.jackrabbit.webdav.observation.SubscriptionManager;

@FunctionalInterface
interface sum{
    public int calculate(int x,int y);

        }
public class OuterClass implements Cloneable {

    int a ;
    int b;

    public OuterClass(InnerClass innerClass) {
        this.a = innerClass.a;
        this.b = innerClass.b;

    }

    public static  class InnerClass{

        int a ;
        int b;

        public InnerClass(int a) {
            this.a = a;
        }

        public InnerClass setB(int b) {
            this.b = b;
            return this;
        }
        public OuterClass build(){
            return new OuterClass(this);
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        OuterClass outer =new OuterClass.InnerClass(23).setB(56).build();
        OuterClass outer1 = (OuterClass) outer.clone();
        System.out.println(outer1.a);
        sum s = (x,y) -> (x+y);
        System.out.println(s.calculate(5,6));
        Thread th =new Thread(()->{
            try {
                Thread.sleep(45);
                System.out.println("I ma in Functional Interfca");
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        });
        th.start();


    }

}


