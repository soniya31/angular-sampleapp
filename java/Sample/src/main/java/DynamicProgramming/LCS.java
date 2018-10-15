package DynamicProgramming;

public class LCS
{



    public static void main(String[] args) {

        char[] c1="abcdaf".toCharArray();
        char[] c2="acbcf".toCharArray();

        int[][] k=new int[c1.length+1][c2.length+1];
        int max=0;
        for(int i=0;i<=c1.length;i++)
        {
            for(int j=0;j<=c2.length;j++)
            {
                if(i==0 || j==0)
                {
                    k[i][j]=0;
                }
                else if (c1[i-1]==c2[j-1])
                {
                    k[i][j]= k[i-1][j-1]+1;
                    if(max<k[i][j])
                        max=k[i][j];

                }
                else
                {
                    k[i][j]= Math.max(k[i-1][j], k[i][j-1]);
                }
            }
        }

        System.out.println("max"+max);

        System.out.println("k "+c1.length);



    }
}
