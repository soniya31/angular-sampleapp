package sort;

public class BS {
    public static void main(String[] args) {

        int arr[] =getInput();
        int i = binarySearch(arr, 0, arr.length - 1, 90);
        if (i >= 0) {
            System.out.println("Item found");
        } else {
            System.out.println("not found");
        }


    }


    public static int binarySearch(int arr[], int l, int h, int item) {
        System.out.println("l:"+l +"\t"+ "h:"+ h);
        if (l <= h) {

            int mid = (l + h) / 2;

            if (arr[mid] == item ){
                System.out.println("found");
                return mid  ;
            }
            else if (item < arr[mid]) {
                return binarySearch(arr, l, mid - 1, item);
            }
            else {
                return binarySearch(arr, mid + 1, h, item);
            }

        }
        return -1;
    }
    public static int[] getInput() {
        int arr[] = {10, 20, 30, 50, 60, 70,90};
        return arr;
    }
}
