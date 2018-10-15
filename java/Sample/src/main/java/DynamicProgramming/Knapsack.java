package DynamicProgramming;

import com.sun.org.apache.xpath.internal.SourceTree;

// A Dynamic Programming based solution for 0-1 Knapsack problem
class Knapsack
{

    // A utility function that returns maximum of two integers
    static int max(int a, int b) { return (a > b)? a : b; }

    // Returns the maximum value that can be put in a knapsack of capacity W
    static int knapSack(int W, int wt[], int val[], int n) {
        int i, w;
        int K[][] = new int[n + 1][W + 1];
        System.out.println(n);
        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        for (i = 0; i <= n; i++)
        {
            for(int j=0;j<=W;j++){
                System.out.print(K[i][j]);
                System.out.print("\t");
            }
            System.out.print("\n");
        }
        return K[n][W];
    }


    // Driver program to test above function
    public static void main(String args[])
    {
        int val[] = new int[]{1, 4, 5,7};
        int wt[] = new int[]{1,3,4,5};
        int  W = 7;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }

}
