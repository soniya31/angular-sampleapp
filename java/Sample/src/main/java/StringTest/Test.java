package StringTest;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        char a[]="Soniya".toCharArray();
        System.out.println(Arrays.toString(a));
        String s="A mf s,fdgfdg, 12  hds ";
               s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(s);
    }
}
