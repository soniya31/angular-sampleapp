package exceptionhandling;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestExceptionB extends TestException{
    public static void main(String[] args) {


        try {
            TestException jk=new TestExceptionB();
            jk.foo();

        }
        catch (ArithmeticException e) {
            System.out.println("in Arithmetic CAtcher");
        }catch (FileNotFoundException  e) {
            System.out.println("File not found exception Catcher");
        }
        finally{
            System.out.println("in finally ");
        }
        System.out.println("In MAin ending");
    }

    public  void foo() throws FileNotFoundException,RuntimeException{
        try {
            System.out.println("in Foo");
            File file = new File("C:/gf.txt");
            FileReader f = new FileReader("C://jhvjh/hjh.txt");
            System.out.println("exiting foo");
        }
        finally{
            System.out.println("in finally-foo   ");
        }
    }
}
