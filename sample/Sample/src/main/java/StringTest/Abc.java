package StringTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Abc {

    public static int specialElement(int[][] matrix) {
        int row = matrix.length;
        int min;
        for (int i = 0; i < row; i++) {
            // FINDING MINIMUM IN EACH ROW//
            min = matrix[i][0];
            for (int j = 1; j < matrix[i].length; j++) {
                if (min > matrix[i][j]) {
                    min = matrix[i][j];
                }
            }// END//

            int k;
            for (int j = 0; j < matrix[i].length; j++) {
                if (min == matrix[i][j]) {
                    //CHECK IF THE SELECTED MIN, IS THE GREATEST IN THE CORRESPONDING COLUMN//
                    for (k = 0; k < row; k++) {
                        if (min < matrix[k][j])
                            break;
                    }

                    if (k == row)
                        return min;

                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
getAll();
    }
    public static void getAll(){
        HashSet<Integer> hm =new HashSet<>();
        List<Integer> l1 = new LinkedList<>();
        l1.add(1);
        l1.add(3);
        l1.add(4);
        List<Integer> l2 = new LinkedList<>();
        l2.add(5);
        l2.add(2);
        l2.add(9);
        List<Integer> l3 = new LinkedList<>();
        l3.add(8);
        l3.add(7);
        l3.add(6);
        ArrayList<List<Integer>> matrix = new ArrayList<>();
        matrix.add(l1);
        matrix.add(l2);
        matrix.add(l3);

        for(int i=0;i<matrix.size();i++){
            List<Integer> list =matrix.get(i);
           // System.out.println(list.get(0));
          //  System.out.println(findMinIndex(list));
            int min = findMinIndex(list);
            int max =findMaxIndex(list);
            System.out.println(list.get(min));
            System.out.println(list.get(max));
            hm.add(list.get(min));
            hm.add(list.get(max));
        }



            List<Integer> list =matrix.get(0);
            for(int col=0;col<list.size();col++){
                int min =Integer.MAX_VALUE;
                int max =Integer.MIN_VALUE;
                for(int row = 0;row < matrix.size();row++)
                {
                    if(min>matrix.get(row).get(col))
                    {
                        min = matrix.get(row).get(col);

                    }
                    if(max<matrix.get(row).get(col))
                    {
                      max=  matrix.get(row).get(col);
                    }
                }
                System.out.println(min);
                System.out.println(max);
                if(min != Integer.MAX_VALUE)
                    hm.add(min);

                if(max != Integer.MIN_VALUE)
                    hm.add(max);
            }




        System.out.println(hm.size());

    }
    public static <T extends Comparable<T>> int findMaxIndex(final List<T> xs) {
        int minIndex;
        if (xs.isEmpty()) {
            minIndex = -1;
        } else {
            final ListIterator<T> itr = xs.listIterator();
            T min = itr.next(); // first element as the current minimum
            minIndex = itr.previousIndex();
            while (itr.hasNext()) {
                final T curr = itr.next();
                if (curr.compareTo(min) > 0) {
                    min = curr;
                    minIndex = itr.previousIndex();
                }
            }
        }

        return minIndex;
    }
    public static <T extends Comparable<T>> int findMinIndex(final List<T> xs) {
        int minIndex;
        if (xs.isEmpty()) {
            minIndex = -1;
        } else {
            final ListIterator<T> itr = xs.listIterator();
            T min = itr.next(); // first element as the current minimum
            minIndex = itr.previousIndex();
            while (itr.hasNext()) {
                final T curr = itr.next();
                if (curr.compareTo(min) < 0) {
                    min = curr;
                    minIndex = itr.previousIndex();
                }
            }
        }

        return minIndex;
    }
}
