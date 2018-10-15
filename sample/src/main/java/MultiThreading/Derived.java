package MultiThreading;

import java.util.concurrent.locks.ReentrantLock;

class Base {
    private void pridfrd(){}
        void display() {
        System.out.println("Static or class method from Base");
    }

    public void print() {
        System.out.println("Non-static or instance method from Base");
    }
}
   public class Derived extends Base {
       private void pridfrd(){}
/*
        static void display() {
           System.out.println("Static or class method from Derived");
       }
*/

       public void print() {
           System.out.println("Non-static or instance method from Derived");
       }

       public static void main(String args[]) {
           Derived obj1 = new Derived();
           obj1.display();
           obj1.print();
           ReentrantLock t =new ReentrantLock();
           //t.
       }
   }