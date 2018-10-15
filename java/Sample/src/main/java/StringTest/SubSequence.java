package StringTest;

public class SubSequence {
    // Returns true if str1[] is a subsequence of str2[]
    // m is length of str1 and n is length of str2
    static boolean isSubSequence(String str1, String str2, int m, int n)
    {
        // Base Cases
        if (m == 0)
            return true;
        if (n == 0)
            return false;

        // If last characters of two strings are matching
        if (str1.charAt(m-1) == str2.charAt(n-1)) {
            boolean flag = isSubSequence(str1, str2, m - 1, n - 1);
            System.out.println(flag +"if matching");
            return  flag;
        }

        // If last characters are not matching
        boolean flag=isSubSequence(str1, str2, m, n-1);
        System.out.println(flag+ "not matching");
        return flag;

    }

    // Driver program
    public static void main (String[] args)
    {
        String str1 = "gksrek";
        String str2 = "geeksforgeeks";
        int m = str1.length();
        int n = str2.length();
        boolean res = isSubSequence(str1, str2, m, n);
        if(res)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
