package pratices;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class ThirdMax {
    public static void main(String[] args) {
        int a = Integer.MIN_VALUE;
        Integer[] nums ={2,2,3,1};
        if(nums.length == 0)
            System.out.println("njb");
        if(nums.length == 1)
            System.out.println(nums[0]);

        HashSet<Integer> hs =new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }

        Integer[] arr = hs.toArray(new Integer[hs.size()]);
        Arrays.sort(arr, Collections.reverseOrder());
        if(arr.length == 2)
            System.out.println(arr[1]);
        System.out.println("arr[2]"+ arr[2]);



    }
}
