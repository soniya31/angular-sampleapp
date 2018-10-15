package collectionList;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

public class IncreasingDecreasingSeq {

    public static void main(String[] args) {
        //ConcurrentHashMap
        Scanner sc =new Scanner(System.in);
        String str =sc.next();
        int i = findPermutation(str);
        System.out.println(i);

    }

    public static int findPermutation(String s) {
        if(s == null){
            return -1;
        }
        int len = s.length();
        if(len == 0){
            return -1;
        }
        s= s.toUpperCase();
        for(int k=0;k< len ; k++){
            if(s.charAt(k) != Character.toUpperCase('i') && s.charAt(k) != Character.toUpperCase('d')){
                return -1;
            }
        }
        int i=0;
        Stack<Integer> st =new Stack<Integer>();
        int[] res =new int[len + 1];
        for(int j=1;j<=len;j++){
            if(s.charAt(j-1) == 'I'){
              st.push(j);
              while(!st.isEmpty()){
                  res[i++]=st.pop();
              }
            }
            else
            {
                st.push(j);
            }
        }
        st.push(len+1);
        System.out.println(st.toString());
        while(!st.isEmpty()){
            res[i++]=st.pop();
        }
        StringBuffer result = new StringBuffer();
        for(int a=0;a< res.length;a++){
            result.append(res[a]);
        }
        int ans= Integer.parseInt(result.toString());
        System.out.println(ans);
        return -1;
    }


}
