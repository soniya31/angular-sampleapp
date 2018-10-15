package testing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class CountDuplicate {
    public static void main(String[] args) {

        String str1 = "abc";
        String str2 = "abbbbbb";
        String str3 = "aabbbbbcdeff";
        String str4 = "aabbbcd";
        System.out.println(compression(str1));
        System.out.println(compression(str2));
        System.out.println(compression(str3));
        System.out.println(compression(str4));

    }

    public static String compression(String str){
     StringBuilder sb =new StringBuilder();
     if(str == null)
         return null;
     if(str.length() == 1)
         return str;

     char ch[] = str.toCharArray();

     for(int i=0; i < str.length();i++){
         if(i == ch.length-1) {
             sb.append(ch[i]);
             break;
         }
          int j = i + 1;
          if(ch[i] != ch[j])
         {
              sb.append(ch[i]);
         }
         else {
             int count = 1;
             while (j < str.length()) {
                 if(ch[i] == ch[j]){
                    count++;
                    i++;
                 }
                 else{
                     sb.append(ch[i]);
                     sb.append(String.valueOf(count));
                     count =1;
                     i=j-1;
                     break;
                 }

                 j =j+1;
             }
             if(count>1){
                 sb.append(ch[i]);
                 sb.append(String.valueOf(count));
             }
         }
     }
     return sb.toString();
    }

    public void getCompression2(String str){

        char ch[] =str.toCharArray();

        HashMap<Character,Integer> hm =new LinkedHashMap<>();
        for(int i=0;i<ch.length;i++){
            if(hm.containsKey(ch[i])){
                hm.put(ch[i],hm.get(ch[i]+1));
            }
            else{
                hm.put(ch[i],1);
            }
        }

        Set set = hm.entrySet();
        Iterator<Map.Entry<Character,Integer>> it =set.iterator();
        StringBuilder sb = new StringBuilder();

        while(it.hasNext()){
            Map.Entry<Character,Integer> entry =it.next();
            if(entry.getValue() == 1){
                sb.append(entry.getKey());
            }
            else{
                sb.append(entry.getKey());
                sb.append(entry.getValue());
            }
        }


    }
}

