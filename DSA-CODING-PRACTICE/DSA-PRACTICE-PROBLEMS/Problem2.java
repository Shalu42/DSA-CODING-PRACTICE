import java.util.*;

public class Problem2 {
    public static int maxProduct(int[] arr) {
        int result = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int curr_sum = 1;
            for (int j = i; j < arr.length; j++) {
                curr_sum *= arr[j];
                result = Math.max(result, curr_sum);
            }
        }
        return result;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the elements:");
        String inputLine = scanner.nextLine(); 
        String[] inputStrings = inputLine.split(" ");
        int[] arr = new int[inputStrings.length];
        for (int i = 0; i < inputStrings.length; i++) {
            arr[i] = Integer.parseInt(inputStrings[i]); 
        }
              System.out.println("Output: " + maxProduct(arr));
        scanner.close();
    }
}
