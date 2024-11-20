import java.util.*;

public class problem10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the sorted elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the element to search:");
        int key = sc.nextInt();
        int result = interpolationSearch(arr, key);
        System.out.println(result == -1 ? "Element not found" : "Element found at index: " + result);
    }

    public static int interpolationSearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high && key >= arr[low] && key <= arr[high]) {
            if (low == high) {
                if (arr[low] == key) return low;
                return -1;
            }
            int pos = low + ((key - arr[low]) * (high - low)) / (arr[high] - arr[low]);

            if (arr[pos] == key) return pos;
            if (arr[pos] < key) low = pos + 1;
            else high = pos - 1;
        }
        return -1;
    }
}
