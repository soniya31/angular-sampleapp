package collectionList;

import java.util.HashMap;

public class Employee {

    int id;
    String name;
/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        return name != null ? name.equals(employee.name) : employee.name == null;
    }*/

   /* @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }*/

    public Employee(int id , String name) {
        this.id = id;
        this.name=name;
    }

    public static void main(String[] args) {
        HashMap<Employee,String> hm=new HashMap<>();
        hm.put(new Employee(12,"Soniya"),"name1");
        hm.put(new Employee(12,"Soniya"),"name1");
        System.out.println("Soniya".hashCode());
        System.out.println("Soniya".hashCode());
    }
}

