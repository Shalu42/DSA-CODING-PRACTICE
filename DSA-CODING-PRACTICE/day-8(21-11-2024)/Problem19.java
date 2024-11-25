import java.util.*;

class Problem19 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        
        // Find the leftmost index of target
        result[0] = binarySearch(nums, target, true);
        if (result[0] == -1) {
            return result; // Target not found
        }
        
        // Find the rightmost index of target
        result[1] = binarySearch(nums, target, false);
        
        return result;
    }
    
    private int binarySearch(int[] nums, int target, boolean left) {
        int leftIndex = 0, rightIndex = nums.length - 1, result = -1;
        
        while (leftIndex <= rightIndex) {
            int mid = leftIndex + (rightIndex - leftIndex) / 2;
            
            if (nums[mid] == target) {
                result = mid;
                if (left) {
                    rightIndex = mid - 1; // Continue searching in the left half
                } else {
                    leftIndex = mid + 1; // Continue searching in the right half
                }
            } else if (nums[mid] < target) {
                leftIndex = mid + 1;
            } else {
                rightIndex = mid - 1;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Problem19 obj = new Problem19();
        
        System.out.println("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        
        int[] nums = new int[n];
        System.out.println("Enter the array elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        
        System.out.println("Enter the target value: ");
        int target = scanner.nextInt();
        
        int[] result = obj.searchRange(nums, target);
        System.out.println("Target range: [" + result[0] + "," + result[1] + "]");
        
        scanner.close();
    }
}
