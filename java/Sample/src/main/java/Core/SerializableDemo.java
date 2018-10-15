package Core;

import javax.sql.rowset.serial.SerialArray;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class D{
    int pagal=34;

    public D(int pagal) {
        this.pagal = pagal;
    }

    public D() {

    }
    public int getPagal() {
        return pagal;
    }

    public void setPagal(int pagal) {
        this.pagal = pagal;
    }
}
public class SerializableDemo extends D implements Serializable,Cloneable{

    private static SerializableDemo demo = null;
    String name;
    transient int age;

    private SerializableDemo(String name, int age) {
        super(56);
        this.name = name;
        this.age = age;
    }
    public static SerializableDemo getInstance(){
        if(demo== null) {
            demo = new SerializableDemo("Soniya", 25);
        }
        demo.toString();
        return demo;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "SerializableDemo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    private Object readResolve() {
return getInstance();
    }

    public static void main(String[] args) {

        try {
            ObjectOutputStream ob =new ObjectOutputStream(new FileOutputStream("file.txt"));
         //   SerializableDemo demo =new SerializableDemo("Soniya",28);
            ob.writeObject(getInstance());

            ObjectInputStream in =new ObjectInputStream(new FileInputStream("file.txt"));
            SerializableDemo sd= (SerializableDemo) in.readObject();
            System.out.println(sd.toString());
            System.out.println(sd.hashCode());
            System.out.println(demo.hashCode());
        } catch ( IOException e ) {
            e.printStackTrace();
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace();
        }
    }
}
