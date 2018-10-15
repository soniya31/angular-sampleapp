package StringTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int matrixRows = Integer.parseInt(bufferedReader.readLine().trim());
        int matrixColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < matrixRows; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < matrixColumns; j++) {
                int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
                matrixRowItems.add(matrixItem);
            }

            matrix.add(matrixRowItems);
        }

        int res = countSpecialElements(matrix);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    // Complete the countSpecialElements function below.
    static int countSpecialElements(List<List<Integer>> matrix) {
        int result = -1;

        for(int i=0;i<matrix.size();i++){
            List<Integer> l1=  matrix.get(i);
            int minIndex =findMinIndex(l1);
            int suspectMaxInColumn= l1.get(minIndex);
            for(int j=0; j < matrix.size();j++){

                if(suspectMaxInColumn < matrix.get(j).get(minIndex)){
                    break;
                }

                result = suspectMaxInColumn;
            }

        }


        return result;
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

  public void getAll(){
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
          hm.add(findMinIndex(list));
          hm.add(findMaxIndex(list));
      }
      System.out.println(hm.size());

  }
}
