package Memory;

import javax.sound.midi.Soundbank;
import javax.xml.bind.SchemaOutputResolver;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MemoryA{
    int a =10;

    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader bf;
        bf = new BufferedReader(new FileReader("df.txt"));
        try(Resource r =new Resource();
        Resource rf=new Resource()) {

            MemoryA memoryA = new MemoryA();
            MemoryA memoryB = memoryA;
            memoryB = null;
            // System.gc();
        }catch(Exception e) {}
    //    System.out.println(memoryA.a);
     // System.out.println(memoryB.a);

    }

//    @Override
//    public void finalize() {
//
//            System.out.println("Closed BufferedReader in the finalizer");
//
//    }


}
 class Resource implements  AutoCloseable{
     @Override
     public void close() throws Exception {
         System.out.println("Closed BufferedReader in the finalizer");

     }
 }