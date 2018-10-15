package testing;

class ParentClass{
    //Static Method
    public static void displayData(){
        System.out.println("in displayData method of class ParentClass");
    }
    // non-static method
    public void displayValues(){
        System.out.println("in displayValues method of class ParentClass");
    }
}
//Derived class
class ChildClass extends ParentClass{
    // Not overridden but hiding the super class displayData method
    public static void displayData(){
        System.out.println("in displayData method of class ChildClass");
    }
    //overriding the super class displayValues method
     public void displayValues(){
        System.out.println("in displayValues method of class ChildClass");
    }
}

public class StaticOverrideDemo {

    public static void main(String[] args) {
        // Parent class Object with a reference of childclass
        ChildClass pc = new ChildClass();
        // no rum time polymorphism parent class method will be called
        pc.displayData();
        // this will call child class method
        pc.displayValues();
ChildClass.displayData();
    }

}
