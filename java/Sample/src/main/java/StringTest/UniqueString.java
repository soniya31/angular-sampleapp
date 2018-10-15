package StringTest;

import java.util.HashSet;

public class UniqueString {
    public static void main(String[] args) {
        String str = "ssoniya";
        trick1(str);
        trick4("Soniya Chopra is");

    }

    public static void trick4(String s) {

        char[] c=s.toCharArray();
        for(int i=0;i<c.length;i++)
        {
            if(c[i]==' ')
            {
                System.out.println(i);
            }
        }
    }
    public static void trick1(String s) {
        System.out.println("in trick1");
        HashSet<Character> hs = new HashSet<>();
        char[] a = s.toCharArray();
        for (char c : a) {
            if (hs.contains(c)) {
                System.out.println(c + " is a repeated character");
                break;
            } else {
                hs.add(c);
            }
        }
    }

    public static void trick2(String s) {
        int len=s.length()-1;
        for(int i=0;i<=len;i++)
        {
            for(int j=0;j<=i;i++)
            {
                if(i!=j)
                {
                    if(s.charAt(i)==s.charAt(j))
                    {
                        System.out.println(s.charAt(j) + " is the repeating character");
                        break;
                    }
                }
            }
        }

    }

    public static boolean trick3(String s) {

        boolean[] ch=new boolean[128];
        for(int i=0;i<ch.length;i++)
        {
            int val=s.charAt(i);
            if(ch[i])
            {
                return false;
            }
            ch[i]=true;
        }
        return true;

    }
}
