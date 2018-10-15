package StringTest;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class GetAllPermutationString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
       Set<String> set= getAllPermutaion(str);
        Iterator<String> itr=set.iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }

    }

    static Set<String> getAllPermutaion(String str) {

        Set<String> hs = new HashSet<>();
        if (str == null)
            return null;
        if (str.length() == 0) {
            hs.add("");
            return hs;
        }
        char begin = str.charAt(0);
        String rest = str.substring(1);
        Set<String> it = getAllPermutaion(rest);
///iterating and reading at the same time

        for (String strNew : it) {
            for (int i = 0; i <= strNew.length(); i++) {
                hs.add(get(begin, strNew, i));
            }
        }
        System.out.println("***************************************************");

        return hs;
    }

    static String get(char c, String target, int i) {
        String b = target.substring(0, i);
        String e = target.substring(i);
        return b + c + e;
    }

}
