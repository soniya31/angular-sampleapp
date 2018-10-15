package StringTest;

import java.util.HashSet;
import java.util.Iterator;

public class DistinctPalidromeSubstring {
   static HashSet<String> hs=new HashSet<>();
    public static void main(String[] args) {

        String str = "geeksfofskeeg";
        for (int i = 0; i < str.length(); i++) {

            permfinder(str,i,i);
         permfinder(str,i,i+1);
        }

        Iterator<String> itr=hs.iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }

    }

    static void permfinder(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
           // System.out.println(str.substring(left,right+1));
            hs.add(str.substring(left,right+1));
            left--;
            right++;

        }

        hs.add(str.substring(left+1,right));

    }

}
