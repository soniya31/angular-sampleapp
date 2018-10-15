package sort;

import java.util.HashSet;

public class HashEqualsDemo {
    public static void main(String[] args) {
        HashSet<Em> hs=new HashSet<>();
        hs.add(new Em(1,2));
        hs.add(new Em(1,2));
        System.out.println(hs.size());
    }

}
