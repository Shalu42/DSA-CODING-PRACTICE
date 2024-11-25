import java.util.Scanner;

class Problem2 {

    public static int findFloor(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] < k) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter the elements of the sorted array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();

        int index = findFloor(arr, k);
        if (index == -1) {
            System.out.println("No element less than or equal to " + k + " found.");
        } else {
            System.out.println("The index of the largest element less than or equal to " + k + " is: " + index);
        }

        sc.close();
    }
}
