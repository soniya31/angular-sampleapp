package stackpkg;

import java.util.Stack;

public class Solution {

    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        // Complete this function
        int len = s.length();
        boolean flag = false;
        if (s != null) {
            if (len % 2 != 0) {
                return "NO";
            }
        } else {
            return "NO";
        }
        for (int i = 0; i <= len - 1; i++) {
            char b1 = s.charAt(i);

            if (b1 == '(' || b1 == '[' || b1 == '{') {
                stack.push(b1);

            } else {
                if (b1 == ')') {
                    if (stack.empty()) {
                        flag = true;
                        break;
                    } else {
                        char val = stack.pop();
                        if (val != '(') {
                            flag = true;
                            break;
                        }
                    }
                } else if (b1 == '}') {
                    if (stack.empty()) {
                        flag = true;
                        break;
                    } else {
                        char val = stack.pop();
                        if (val != '{') {
                            flag = true;
                            break;
                        }
                    }
                } else if (b1 == ']') {
                    if (stack.empty()) {
                        flag = true;
                        break;
                    } else {
                        char val = stack.pop();
                        if (val != '[') {
                            flag = true;
                            break;
                        }
                    }
                }
            }
        }
        if (flag)
            return "NO";
        else {
            if (stack.empty()) {
                return "YES";
            } else {
                return "NO";
            }
        }
    }


    public static void main(String[] args) {
      /*  Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            String result = isBalanced(s);
            System.out.println(result);
        }
        in.close();
    }*/
        String result = isBalanced("{{}(");
        System.out.println(result);
    }
}
