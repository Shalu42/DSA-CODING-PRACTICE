import java.util.*;

class Problem3{
    public int[] findFirstAndLast(int arr[], int n, int x) {
        int[] result = new int[2];
        
        result[0] = findFirstOccurrence(arr, n, x);
        result[1] = findLastOccurrence(arr, n, x);
        
        return result;
    }

    private int findFirstOccurrence(int arr[], int n, int x) {
        int low = 0, high = n - 1, first = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (arr[mid] == x) {
                first = mid;
                high = mid - 1;  // Search in the left half to find the first occurrence
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return first;
    }

    private int findLastOccurrence(int arr[], int n, int x) {
        int low = 0, high = n - 1, last = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (arr[mid] == x) {
                last = mid;
                low = mid + 1;  // Search in the right half to find the last occurrence
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return last;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int x = sc.nextInt();
        
        Problem3 solution = new Problem3();
        int[] result = solution.findFirstAndLast(arr, n, x);
        
        System.out.println(Arrays.toString(result));
        
        sc.close();
    }
}
