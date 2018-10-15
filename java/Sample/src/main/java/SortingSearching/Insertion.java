package SortingSearching;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Insertion {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter size of Array");
            int size = sc.nextInt();
            int[] arr = new int[size];
            System.out.println("Enter array elements");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }

            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = key;
            }


            System.out.println("Sotrted list is:");
            printarr(arr);
        }
        catch (InputMismatchException ex )
        {
            System.out.println("Enter correct input"+ex);
        }
    }

    public static void printarr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
