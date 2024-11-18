import java.util.*;

public class problem6 {
    public static String largestNumber(int[] arr) {
        String[] strArr = Arrays.stream(arr)
                                .mapToObj(String::valueOf)
                                .toArray(String[]::new);
        Arrays.sort(strArr, (a, b) -> (b + a).compareTo(a + b));
        if (strArr[0].equals("0")) return "0";
        return String.join("", strArr);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Largest number formed: " + largestNumber(arr));
    }
}
