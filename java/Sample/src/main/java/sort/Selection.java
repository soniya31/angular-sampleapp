package sort;

public class Selection {

    public static void main(String[] args) {
        int[] arr = {23, 56, 12, 10, 2, 3, 89};


        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        Utility.printArray(arr);
    }
}
