package sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {23, 56, 12, 10, 100, 3, 89};

        int a[]=sort(arr,0,arr.length-1);
        Utility.printArray(a);
    }

    public static int[] sort(int[] a, int l, int h) {

        if(l<h) {
            int i = partition(a, l, h, a[h]);

            sort(a, l, i - 1);
            sort(a, i + 1, h);
        }
        return  a;
    }

    public static int partition(int[] a, int l, int h, int pivot) {

        int i = l - 1;

        for (int j = l; j < h; j++) {
            if (a[j] <= pivot) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }

        }
        a[h] = a[i + 1];
        a[i + 1] = pivot;
        return i + 1;

    }

}
