package exceptionhandling;

import javax.sound.midi.Soundbank;
import javax.xml.bind.SchemaOutputResolver;

public class ReturnInCatchAndFinal {

    public int foo(StringBuffer ef) throws RuntimeException{

        try{
           // int s=5/0;
          //  throw new RuntimeException();
          //  return 7;
        }catch(ArithmeticException e){
         return 5;
        }
        finally {
        //    System.out.println("In Finally Block");
           return 6;
        }

    }
    public int foo(StringBuilder ef) throws RuntimeException{
        System.out.println("In Run");
        try{
            // int s=5/0;
            //  throw new RuntimeException();
              return 7;
        }catch(ArithmeticException e){
            System.out.println("In Catch Block");
            return 5;
        }
        finally {
               System.out.println("In Finally Block");
            return 6;
        }

    }

    public static void main(String[] args) {
 ReturnInCatchAndFinal re =new ReturnInCatchAndFinal();
        try {
            System.out.println(re.foo(new StringBuffer("ddd")));
        }catch ( NullPointerException e ){

            System.out.println("In Null Exception Block");
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

}
