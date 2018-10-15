package sort;

public class Insertion {
    public static void main(String[] args) {
        int[] arr = {23, 56, 12, 10, 2, 3, 89};


        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int key = arr[i];
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;


        }

        Utility.printArray(arr);
    }
}
