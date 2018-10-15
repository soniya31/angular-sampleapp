package collectionList;

import Pojo.Product;
import interfaceList.Drawable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ProdFactory {
    public static void main(String[] args) {
        List<Product> list=new ArrayList<>();
        Product prod1=new Product(1,"A");
        Product prod2=new Product(2,"B");
        Product prod3=new Product(3,"C");
        Product prod4=new Product(4,"D");
        list.add(prod1);
        list.add(prod2);
        list.add(prod3);
        list.add(prod4);
        list.forEach(
                (l)-> System.out.println(l.productName)

        );

        Stream<Product> productStream=list.stream().filter(p->p.productId>2);

       productStream.forEach(
               d-> System.out.println(d.productId)
       );

        Drawable drawable=(a,b)-> (a+b);
        System.out.println(drawable.add(23,89));

        Runnable runnable=()-> System.out.println("I am in runnable method");
        Thread th1=new Thread(runnable);
        th1.start();

        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7);
        //int sum = list1.stream().map(x -> x*x).reduce((x,y) -> x + y).get();
        int sum = list1.stream().map(x->x*x).reduce((x,y)->x+y).get();

        System.out.println(sum);
        int arr[] = {64, 34, 25, 12, 22, 11, 90};

        bubbleSort(arr, arr.length);

        System.out.println("Sorted array : ");
        System.out.println(Arrays.toString(arr));


    }



    static void bubbleSort(int arr[], int n)
    {
        // Base case
        if (n == 1)
            return;

        // One pass of bubble sort. After
        // this pass, the largest element
        // is moved (or bubbled) to end.
        for (int i=0; i<n-1; i++)
            if (arr[i] > arr[i+1])
            {
                // swap arr[i], arr[i+1]
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }

        // Largest element is fixed,
        // recur for remaining array
        bubbleSort(arr, n-1);
    }
}
