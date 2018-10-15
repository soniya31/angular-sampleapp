import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StringQuestion {
    public static void main(String[] args) {
        // Scanner sc =new Scanner(System.in);
        int[] arr = {1, 1, 1, 2, 5, 6, 7, 8, 1, 1, 1};
        if(arr.length== 0 )
        {
            System.out.println("NO");
        }
        else if(arr.length ==1)
        {
            System.out.println("yes");
        }
        else if(arr.length > 1) {
            int count ;
            if(arr.length % 2 == 0)
             count = arr.length / 2 ;
            else{
                count = arr.length / 2 + 1;            }
            HashMap<Integer, Integer> hm = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                if (hm.containsKey(arr[i])) {
                    hm.put(arr[i], hm.get(arr[i]) + 1);
                } else {
                    hm.put(arr[i], 1);
                }
            }

            Set<Map.Entry<Integer, Integer>> set = hm.entrySet();
            ArrayList<Map.Entry<Integer, Integer>> al = new ArrayList<>(set);
            Collections.sort(al, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            });
            System.out.println(al.get(0).getValue());
            System.out.println(count);
            if(al.get(0).getValue() >= count){
                System.out.println("Yes");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
