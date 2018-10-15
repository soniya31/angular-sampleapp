package collectionList;

import javax.swing.text.html.HTMLDocument;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Subsequence
{

static HashSet<String> st = new HashSet<>();
    // Driver code
    public static void main(String[] args)
    {
        String s = "ABCD";
        subsequence(s);
         System.out.println(st.size());
        iterateSet(st);
       // System.out.println(s);
    }

    private static void subsequence(String str) {

        for (int i = 0; i < str.length(); i++) {

            // iterate from the end of the string
            // to generate substrings
            for (int j = str.length(); j > i; j--) {
                String sub_str = str.substring(i, j);

               if (!st.contains(sub_str))
                    st.add(sub_str);

                //waste code==>Studity of SOniya CHopra ;)
                // drop kth character in the substring
                // and if its not in the set then recur
                for (int k = 1; k < sub_str.length() - 1; k++) {
                    StringBuffer sb = new StringBuffer(sub_str);

                    // drop character from the string
                    sb.deleteCharAt(k);
                    if (!st.contains(sb))
                        ;
                    subsequence(sb.toString());
                    //subsequence(sb.insert("dfbbdsf","ffhjsfdf"),"sefjhsjhdfhsddhd");

                }
            }
        }



    }

    public static void iterateSet(Set s) {
     //   System.out.println(s.size());
       // Iterator<String> it=s.iterator();
        s.forEach(
                n-> System.out.println(n)
        );

    }
}
