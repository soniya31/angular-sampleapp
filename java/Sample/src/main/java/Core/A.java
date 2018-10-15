package Core;



class B {
    int a =10;
    B(){}
    void execute(){
        System.out.println("in B");
    }
}

public class A extends B {
    int a =100;
    int c=40;
    void execute(){
        System.out.println("in A");
    }
    public static void main(String[] args) {
        B b =new B();
//        A a =(A)new B();
      //  System.out.println(a.c);;
        System.out.println(b.a);
       b.execute();
    }
}
