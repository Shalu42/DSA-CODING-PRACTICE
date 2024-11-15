import java.util.*;

public class Problem6{
    public static int trapWater(int[] arr) {
        int n = arr.length;
        
        if (n == 0) {
            return 0;
        }
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Fill leftMax array
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }
        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            // Water trapped on top of each bar is the difference between
            // the height of the bar and the minimum of max heights on its left and right
            totalWater += Math.min(leftMax[i], rightMax[i]) - arr[i];
        }

        return totalWater;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the elements:");
        String inputLine = scanner.nextLine(); 
        String[] inputStrings = inputLine.split(" ");
        int[] arr = new int[inputStrings.length];
        for (int i = 0; i < inputStrings.length; i++) {
            arr[i] = Integer.parseInt(inputStrings[i]); 
        }

      System.out.println("Output: "+ trapWater(arr));
      scanner.close();
    }
}
