package stackpkg;

import java.util.Scanner;
import java.util.Stack;

public class TextEditor {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < n; i++) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    stack.push(sb.toString());
                    String str = sc.next();
                    sb.append(str);
                    break;

                case 2:
                    stack.push(sb.toString());
                    int lastCh = sc.nextInt();
                // sb.delete(index - 1, sb.length() - 1);
                   sb=new StringBuilder(sb.substring(0, sb.length()-lastCh));

                    break;

                case 3:
                    int index1 = sc.nextInt();
                    System.out.println(sb.charAt(index1 - 1));
                    break;
                case 4:
                    if (!stack.empty())
                        sb=new StringBuilder(stack.pop());
                   // System.out.println(sb);
                    break;

                default:
                    System.out.println("Wrong choice");

            }

        }
    }
}
