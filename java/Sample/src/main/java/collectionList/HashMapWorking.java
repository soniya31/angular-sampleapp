package collectionList;

import org.apache.jackrabbit.jcr2spi.operation.Copy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class HashMapWorking {
    public static void main(String[] args) {
        HashMap<Emp,Integer> hm=new HashMap<>();
        Emp e1 =new Emp("Soniya",1);
        Emp e2 =new Emp("Teena",2);
        Emp e3 =new Emp("Teena",3);
        hm.put(e1,1);
        hm.put(e2,2);
        hm.put(e3,3);
        CopyOnWriteArrayList<String> al = new CopyOnWriteArrayList<String>();
        al.add("ad");
        al.add("dsj");
        al.add("sdvsd");

        al.add("ddfjddhhid");

        Iterator<String> it = al.iterator();
        while(it.hasNext()){
            String st = it.next();
           if(st.equalsIgnoreCase("ad"));
           al.remove(st);
            System.out.println(st);
        }
        Iterator<String> it1 = al.iterator();
        while(it1.hasNext()){
            System.out.println("Please enter");
            String st = it1.next();

            System.out.println(st);
        }
        System.out.println(hm.size());
    }
}

class Emp{
    String name;
    int id;

   @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Emp emp = (Emp) o;

        if (this.name.equalsIgnoreCase( emp.name)) return true;
      return false;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result  ;
        return result;
    }

    public Emp(String name, int id){

        this.name=name;
        this.id=id;
    }

    public int getId(){
        return id;
    }

}