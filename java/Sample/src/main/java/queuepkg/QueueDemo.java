package queuepkg;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        int[] arr=new int[3];
        arr[0]=0;
        arr[1]=1;
        arr[2]=2;

        int newSize=5;
        arr= Arrays.copyOf(arr,newSize);
        System.out.println(arr[2]);

    }

}
