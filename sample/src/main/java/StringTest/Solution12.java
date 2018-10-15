package StringTest;

public class Solution12 {
    public static String shiftingLetters(String S, int[] shifts) {

        if(S == null || shifts.length ==0){
            return null;
        }

        for(int i=0;i<S.length();i++){
            StringBuffer sb =new StringBuffer();
            for(int j=0;j<=i;j++){
                char ch = (char)(((int)S.charAt(j) + shifts[i] -97)%26 + 97);
                sb.append(ch);

            }
            if(i< S.length()-1)
            sb.append(S.substring(i+1));
            S=sb.toString();
        }
        System.out.println(S);
        return S;
    }

    public static void main(String[] args) {
        int[] a = {3,5,9};
        Solution12.shiftingLetters("abc",a);
        char[] b ="abc".toCharArray();
    }
}
