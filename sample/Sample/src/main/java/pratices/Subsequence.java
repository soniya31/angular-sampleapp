package pratices;

import java.util.HashSet;

public class Subsequence {
    public static void main(String[] args) {

        String str1 ="aieef";
        String str2 ="klaief";

        HashSet<Character> hashset =new HashSet<>();
        hashset.add('a');
        hashset.add('e');
        hashset.add('i');
        hashset.add('o');
        hashset.add('u');
getVowelSubsequence(hashset,str1,str2);
        getSubsequence(str1,str2);


    }

    public static void getVowelSubsequence(HashSet<Character> hs , String str1 ,String str2){

        int table[][] =new int[str1.length()+1][str2.length()+1];
        char ch1[] = str1.toCharArray();
        char ch2[] = str2.toCharArray();

        for(int i=1;i<table.length;i++){
            for(int j=1;j<table[0].length;j++) {

                if (hs.contains(ch1[i-1])) {
                    if (ch1[i-1] == ch2[j-1]) {
table[i][j] = table[i-1][j-1]+1;
                    }
                    else{
                        table[i][j] = Math.max(table[i-1][j],table[i][j-1]);
                    }
                }
                else{
                    table[i][j] = table[i-1][j];
                }
            }
        }
        System.out.println(table[str1.length()][str2.length()]);
    }


    public static void getSubsequence(String str1 ,String str2){
        int table[][] =new int[str1.length()+1][str2.length()+1];
        char ch1[] = str1.toCharArray();
        char ch2[] = str2.toCharArray();

        for(int i=1;i<table.length;i++){
            for(int j=1;j<table[0].length;j++) {


                    if (ch1[i-1] == ch2[j-1]) {
                        table[i][j] = table[i-1][j-1]+1;
                    }
                    else{
                        table[i][j] = Math.max(table[i-1][j],table[i][j-1]);
                    }
                }

        }
        System.out.println(table[str1.length()][str2.length()]);
    }

}
