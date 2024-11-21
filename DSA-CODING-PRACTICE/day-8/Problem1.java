import java.util.*;

public class Problem1 {
    public static boolean isPalindrome(String s) {
        StringBuilder filtered = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                filtered.append(Character.toLowerCase(c));
            }
        }
        String cleaned = filtered.toString();
        String reversed = filtered.reverse().toString();
        return cleaned.equals(reversed);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to check if it's a palindrome:");
        String s = sc.nextLine();
        boolean result = isPalindrome(s);
        System.out.println("Is the string a palindrome? " + result);
    }
}
