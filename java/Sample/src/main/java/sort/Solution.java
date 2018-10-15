package sort;

import java.util.Scanner;

public class Solution {
    /*100
    DNFjxo?b5h*5<LWbgs6?V5{3M].1hG)pv1VWq4(!][DZ3G)riSJ.CmUj9]7Gzl?VyeJ2dIPEW4GYW*scT8(vhu9wCr]q!7eyaoy.
        45*//*100
    DNFjxo?b5h*5<LWbgs6?V5{3M].1hG)pv1VWq4(!][DZ3G)riSJ.CmUj9]7Gzl?VyeJ2dIPEW4GYW*scT8(vhu9wCr]q!7eyaoy.
        45*/
    static String caesarCipher(String s, int k) {

        int MAX=(int) 'Z';
        int max=(int) 'z';
        int MIN=(int) 'A';
        int min=(int) 'a';
        char[] c=s.toCharArray();
         k=k%26;

        for(int i=0;i<c.length;i++)
        {
            int ascii=(int) c[i];
            if(min <= ascii && ascii<=max){
                ascii+=k;
                if(ascii>max)
                {
                    int diff=ascii-max;
                    c[i]=(char) (min+diff-1);
                }
                else{
                    c[i]=(char)  ascii;
                }
            }

            else if( MIN <= ascii && ascii<=MAX){
                ascii+=k;
                if(ascii>MAX)
                {
                    int diff=ascii-MAX;
                    c[i]=(char) (MIN+diff-1);

                }
                else{
                    c[i]=(char)  ascii;
                }
            }

            else{
                c[i]=(char) ascii ;
            }
        }


        return new String(c);


    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.next();
        int k = in.nextInt();
        String result = caesarCipher(s, k);
        System.out.println(result);
        in.close();
    }
}

