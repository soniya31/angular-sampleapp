package SortingSearching;

public class MergeSort {
    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("Sorted array");
        printArray(arr);
    }

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r) {

        int a1[] = new int[m - l + 1];
        int a2[] = new int[r - m ];


        for (int i = 0; i < arr.length; i++) {
            while (i <= m) {
                a1[i] = arr[i];
            }
            a2[i] = arr[i];
        }

        int j = 0;
        int i = 0;
        int k = 0;
        while (i < a1.length && j < a2.length) {
            if (a1[i] <= a2[j]) {
                arr[k] = a1[i];
                k++;
                i++;
            } else {
                arr[k] = a2[j];
                k++;
                j++;
            }

        }

        while (i < a1.length) {
            arr[k] = a1[i];
            k++;
            i++;
        }
        while (j < a2.length) {
            arr[k] = a2[j];
            k++;
            j++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r) {

        if (l < r) {
            int mid = l + r / 2;
            sort(arr, l, mid);
            sort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }

    }
}
