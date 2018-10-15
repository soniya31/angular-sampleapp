/*
package sort;


import java.util.Scanner;

public class CandiateCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        int a[] = {0, 2, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1, 2, 0, 1, 0, 2};
        int index = 0;
        for (index = 0; index < a.length; index++) {
            if (a[index] > 0)
                break;
        }
        int elevation = index;
        int j;

        for (int sel = index ; sel < a.length; sel++) {
            j = sel+1;
            while (j < a.length) {

                if (a[j] >= a[elevation]) {
                    for (int m = elevation + 1; m < j; m++) {
                        System.out.println("indexes are:" + m);
                    }
                    elevation = j;
                    j++;
                    sel = j;
                    break;
                } else {
                    j++;
                }

            }
           // elevation=
        }
    }
}
*/
