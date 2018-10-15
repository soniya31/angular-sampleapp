package Memory;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;

public class Serialization implements Cloneable,Serializable {

    int id;
    String name;
    Date date;
    HashSet<String> hm;

    public Serialization(int id, String name, Date date, HashSet<String> hm) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.hm =hm;

    }

   private Object writeReplace(){
      return new Object();
   }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
private static class DataProxy implements  Serializable{

       DataProxy(Serialization sc){

       }


    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public HashSet<String> getHm() {
        return hm;
    }

    public void setHm(HashSet<String> hm) {
        this.hm = hm;
    }
    @Override
    public Object clone() throws  CloneNotSupportedException{
    Serialization clone ;
    clone = (Serialization) super.clone();
    clone.setDate((Date) this.getDate().clone());
    clone.setHm((HashSet<String>) this.getHm().clone());
    return  clone;
    }
    public static void main(String[] args) {
        HashSet<String> hm =new HashSet<>();
        hm.add("Soniya");
        Serialization sc =new Serialization(12,"Soniya",new Date(),hm);
        Serialization sc_two = null;
        try {
             sc_two=(Serialization)sc.clone();
        } catch ( CloneNotSupportedException e ) {
            e.printStackTrace();
        }
         hm.add("ddg");
        System.out.println(sc_two.getHm().size());
    }
}
