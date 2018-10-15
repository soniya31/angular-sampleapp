package stackpkg;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;

public class Stacky {

    public static void main(String[] args) {
        Stack<Long> stack=new Stack<Long>();
        Scanner sc=new Scanner(System.in);
        long a=sc.nextLong();

        for(long i=0;i<a;i++)
        {
            int choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    long item=sc.nextInt();
                    stack.push(item);
                    break;

                case 2:
                    if(!stack.empty())
                        stack.pop();
                    break;

                case 3:

                    if(!stack.empty()){
                        long max=Integer.MIN_VALUE;
                        for(int j=stack.size()-1;j>=0;j--)
                        {
                            if(max<stack.get(j))
                            {
                                max=stack.get(j);
                            }
                        }
                        System.out.println(max);
                    }

                    break;
                default: System.out.println("wrong choice");
            }


        }
        System.out.println("Switch over");
    }
}
