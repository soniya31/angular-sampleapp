package StringTest;

import java.util.HashSet;
import java.util.Set;

public class StringHelper        {

    public  Set<String> permutationFinder(String str) {
        Set<String> perm = new HashSet<String>();
        //Handling error scenarios
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        char initial = str.charAt(0); // first character
        String rem = str.substring(1); // Full string without first character
        Set<String> word = permutationFinder(rem);
        System.out.println(perm.hashCode());
        System.out.println(word.hashCode());
        Set<String> words=new HashSet<>(word);
        for (String strNew : words) {
            for (int i = 0;i<=strNew.length();i++){
                perm.add(charInsert(strNew, initial, i));
            }
        }
        return perm;
    }

    public static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }

    public static void main(String[] args) {
        StringHelper h=new StringHelper();
      //  String s = "AAC";
        String s1 = "ABC";
        //String s2 = "ABCD";
        //System.out.println("\nPermutations for " + s + " are: \n" + permutationFinder(s));
        System.out.println("\nPermutations for " + s1 + " are: \n" + h.permutationFinder(s1));
        //System.out.println("\nPermutations for " + s2 + " are: \n" + permutationFinder(s2));
    }
}
