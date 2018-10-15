package Core;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;

public class Test {
    public void foo(Test o) {
        System.out.println("Object");
    }

    public void foo(Object s) {
        System.out.println("String");
    }
    public static void main(String[] args) {

        new Test().foo(null);
        String s1 = "abc";
        StringBuffer s2 = new StringBuffer(s1);
        System.out.println(s1.equals(s2));  //equals instance of method will return false


        String st1 = "abc";
        String st2 = new String("abc");
        st2=st2.intern();
        System.out.println(st1 ==st2);


        String s = "abcaad,";
        String[] strarry=s.split("");
        System.out.println();
        for(int i=0;i<strarry.length;i++)
        {
            System.out.println(i+strarry[i]);
        }

    }

}
