package sort;

public class LS {

//complecity o(n)
    public static void main(String[] args) {

        int arr[] = Utility.getInput();
        int item = 70;
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (item == arr[i]) {

                flag = true;
                break;
            }

        }

        if (flag) {
            System.out.println("item found");
        } else {
            System.out.println("item not found");
        }
    }
}
