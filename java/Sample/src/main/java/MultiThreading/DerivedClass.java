package MultiThreading;

class BaseClass{
    static {
        System.out.println("In Base");
    }
     static void getBase(){
         System.out.println("Get Base");
     }

    public BaseClass() {
        System.out.println("In Base Const");
    }

    void derivedMethod(){
        System.out.println("BAse Method");

    }
}
public class DerivedClass extends BaseClass {
    static {
        System.out.println("In Derived");
    }
    public DerivedClass(int x,int y) {
        super();
        System.out.println("In derived Const");
    }

    static void getBase(int a){
        System.out.println("Get Derived");
    }

    void derivedMethod(){
        System.out.println("Derive Method");
    }
     /*static void getBase(){
        System.out.println("Get Derived");
    }
     void getBase(int a){
        System.out.println("Get Derived");
    }*/

    public static void main(String[] args) {
        BaseClass base =new DerivedClass(2,4);
      //  BaseClass base1 =new DerivedClass();
        base.getBase();
        base.derivedMethod();
      //  DerivedClass.getBase();
        // base = base1;

    }
}
