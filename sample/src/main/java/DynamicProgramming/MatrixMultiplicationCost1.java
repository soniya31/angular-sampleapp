package DynamicProgramming;

public class MatrixMultiplicationCost1 {
    public int findCost(int arr[]){
        int temp[][] = new int[arr.length][arr.length];
        int q = 0;
        for(int l=2; l < arr.length; l++){
            for(int i=0; i < arr.length - l; i++){
                int j = i + l;
               temp[i][j] = Integer.MAX_VALUE;
                for(int k=i+1; k < j; k++){
                    q = temp[i][k] + temp[k][j] + arr[i]*arr[k]*arr[j];
                    if(q < temp[i][j]){
                        temp[i][j] = q;
                    }
                }
            }
        }

        System.out.println("******* Printing content*****************");
        for(int i=0;i<temp.length;i++){
            for(int j=0;j<temp[0].length;j++){
                System.out.print(temp[i][j]);
                System.out.print("\t");
            }
            System.out.println("");
        }
        return temp[0][arr.length-1];
    }

    public static void main(String args[]){
        MatrixMultiplicationCost1 mmc = new MatrixMultiplicationCost1();
        int arr[] = {4,2,3,5,3};
        int cost = mmc.findCost(arr);
        System.out.print(cost);
    }
}
