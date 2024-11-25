import java.util.*;

public class Problem9 {
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> tFrequency = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFrequency.put(c, tFrequency.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, matched = 0, minLength = Integer.MAX_VALUE;
        int start = 0;
        Map<Character, Integer> windowFrequency = new HashMap<>();

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            windowFrequency.put(rightChar, windowFrequency.getOrDefault(rightChar, 0) + 1);

            if (tFrequency.containsKey(rightChar) && windowFrequency.get(rightChar) <= tFrequency.get(rightChar)) {
                matched++;
            }

            while (matched == t.length()) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                windowFrequency.put(leftChar, windowFrequency.get(leftChar) - 1);
                if (tFrequency.containsKey(leftChar) && windowFrequency.get(leftChar) < tFrequency.get(leftChar)) {
                    matched--;
                }
                left++;
            }

            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string s:");
        String s = sc.nextLine();
        System.out.println("Enter the string t:");
        String t = sc.nextLine();
        String result = minWindow(s, t);
        System.out.println("The minimum window substring is: " + result);
    }
}
