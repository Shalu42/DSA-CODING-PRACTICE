import java.util.*;

public class problem3 {
    public static char firstNonRepeatingCharacter(String s) {
        int[] frequency = new int[26];
        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            if (frequency[c - 'a'] == 1) {
                return c;
            }
        }
        return '$';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String s = scanner.nextLine();
        char result = firstNonRepeatingCharacter(s);
        System.out.println(result == '$' ? "$" : result);
    }
}
