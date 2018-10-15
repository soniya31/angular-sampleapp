package exceptionhandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestException {

    public  void foo() throws FileNotFoundException,NullPointerException {
        try {
            System.out.println("in Foo");
            File file=new File("C:/gf.txt");
            FileReader f=new FileReader("C://jhvjh/hjh.txt");
            System.out.println("exiting foo");
        }catch (IOException e) {
            System.out.println("fun File not found exception Catcher");
        }
        finally{
            System.out.println("in finally-foo   ");
        }
    }
}
