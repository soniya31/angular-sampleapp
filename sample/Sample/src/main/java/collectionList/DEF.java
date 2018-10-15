package collectionList;

import java.util.HashSet;

public class DEF extends ABC {

    public void get(){
        System.out.println("DEF");
    }
    public void print(){
        System.out.println("print");
    }

    public static void main(String[] args) {
        ABC A = new DEF();
        A.get();
        HashSet<Employee> hs = new HashSet<>();
        Employee e1=new Employee(1,"Soniya");
        Employee e2=new Employee(1,"Soniya");
        Employee e3=new Employee(1,"Soniya");
        hs.add(e1);
        hs.add(e2);
        hs.add(e3);
        System.out.println(hs.size());
    }
}
