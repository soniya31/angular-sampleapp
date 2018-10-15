package StringTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class FindAndReplacePattern {
    public static List<String> findAndReplacePattern(String[] words, String pattern) {

        if(pattern == null || pattern.isEmpty() || words.length == 0)
            return null;

        List<String> list =new ArrayList<>();
        char[] pat = pattern.toCharArray();
        HashSet<Character> hs =new HashSet<>();
        for(int i=0;i<pat.length;i++){
            hs.add(pat[i]);
        }

        for(int i=0;i<words.length;i++){
            HashSet<Character> suspect =new HashSet<>();
            for(int j=0;j<words[i].length();j++){
                char[] p = words[i].toCharArray();
                for(int k=0;k<p.length;k++){
                    suspect.add(p[k]);
                }
            }
            if(suspect.size() == hs.size())
                list.add(words[i]);

        }
        Iterator<String> itr =list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        //System.out.println(list.size());
        return list ;
    }

    public static void main(String[] args) {
        String[] str= {"abc","deq","mee","aqq","dkd","ccc"};
        System.out.println("abc".indexOf("bc"));
       // FindAndReplacePattern.findAndReplacePattern(str,"abb");
       // Stack<Integer> st = new Stack();
     //   st.s
    }
}
