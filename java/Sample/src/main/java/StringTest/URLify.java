package StringTest;

import java.util.HashSet;

public class URLify {


    public static void main(String[] args) {
        String target = "My name is soniya Chopra            ";
        int truelength = 24;
        int strlength = target.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < truelength; i++) {
            if (target.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(target.charAt(i));
            }

        }
        System.out.println(sb.toString());

        ///second way
        int sc = 0;
        int a=truelength;
        while (a >0) {
            if (target.charAt(a - 1) == ' ') {

                sc++;
            }
            a--;
        }
       char[] ch=target.toCharArray();
        while(truelength>0)
        {
            if(ch[--truelength]==' ')
            {
            ch[--strlength]='0';
                ch[--strlength]='2';
                ch[--strlength]='%';

            }
            else
            {
                           ch[--strlength]=ch[truelength];

            }

        }
        System.out.println(new String(ch));

    }


}
