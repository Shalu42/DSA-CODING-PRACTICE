import java.util.*;

public class problem9 {
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
        int result = ternarySearch(arr, 0, n - 1, key);
        System.out.println(result == -1 ? "Element not found" : "Element found at index: " + result);
    }

    public static int ternarySearch(int[] arr, int left, int right, int key) {
        if (right >= left) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            if (arr[mid1] == key) return mid1;
            if (arr[mid2] == key) return mid2;

            if (key < arr[mid1]) return ternarySearch(arr, left, mid1 - 1, key);
            else if (key > arr[mid2]) return ternarySearch(arr, mid2 + 1, right, key);
            else return ternarySearch(arr, mid1 + 1, mid2 - 1, key);
        }
        return -1;
    }
}
