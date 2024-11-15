import java.util.Scanner;

class Problem15{
    public static String longestPalindrome(String str) {
        if (str == null || str.length() < 2) return str;
        
        int start = 0, maxLength = 1;
        
        for (int i = 0; i < str.length(); i++) {
            int len1 = expandFromCenter(str, i, i);
            int len2 = expandFromCenter(str, i, i + 1);
            int len = Math.max(len1, len2);
            
            if (len > maxLength) {
                maxLength = len;
                start = i - (len - 1) / 2;
            }
        }
        
        return str.substring(start, start + maxLength);
    }

    private static int expandFromCenter(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the string: ");
        String str = scanner.nextLine();
        
        System.out.println("Longest Palindromic Substring: " + longestPalindrome(str));
    }
}
