import java.util.Arrays;
import java.util.Scanner;

public class problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first string (s1): ");
        String s1 = scanner.nextLine();
        System.out.print("Enter the second string (s2): ");
        String s2 = scanner.nextLine();
        
        if (areAnagrams(s1, s2)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        
        scanner.close();
    }

    public static boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        return Arrays.equals(arr1, arr2);
    }
}
