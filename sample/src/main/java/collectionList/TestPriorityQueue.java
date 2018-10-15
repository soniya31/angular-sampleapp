package collectionList;

import java.util.Iterator;
import java.util.PriorityQueue;

public class TestPriorityQueue {
    static PriorityQueue<String> p =new PriorityQueue<>();

    public static void main(String[] args) {
        p.add("Teena");
        p.add("Abc");
        p.add("Soniya");
        p.add("Banana");


        Iterator<String> it = p.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
