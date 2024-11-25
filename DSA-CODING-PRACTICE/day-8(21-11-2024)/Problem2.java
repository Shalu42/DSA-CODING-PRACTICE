import java.util.*;

public class Problem2 {
    public static boolean isSubsequence(String s, String t) {
        int sIndex = 0, tIndex = 0;
        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            tIndex++;
        }
        return sIndex == s.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string s:");
        String s = sc.nextLine();
        System.out.println("Enter string t:");
        String t = sc.nextLine();
        boolean result = isSubsequence(s, t);
        System.out.println("Is string s a subsequence of string t? " + result);
    }
}
