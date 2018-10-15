package SortingSearching;

import java.util.Scanner;

public class SelectionSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter comma separted array");
        String arrString = sc.next();

        String arr[] = arrString.split(",");
        int size = arr.length;
        int[] intarr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            intarr[i] = Integer.parseInt(arr[i]);

        }

        for (int j = 0; j < intarr.length - 1; j++) {
            int index = j;
            for (int i = j + 1; i < intarr.length; i++) {
                if (intarr[index] > intarr[i]) {
                    index = i;
                }
            }

            int temp = intarr[index];
            intarr[index] = intarr[j];
            intarr[j] = temp;
        }
        printarr(intarr);

    }

    public static void printarr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }


}
