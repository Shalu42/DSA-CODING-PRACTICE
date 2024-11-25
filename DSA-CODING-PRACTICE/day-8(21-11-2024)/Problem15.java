import java.util.*;

class Problem15 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return left; // The position where the target would be inserted
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Problem15 obj = new Problem15();
        
        System.out.println("Enter the sorted array (space-separated): ");
        String[] input = scanner.nextLine().split(" ");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        
        System.out.println("Enter the target value: ");
        int target = scanner.nextInt();
        
        int result = obj.searchInsert(nums, target);
        System.out.println("Target index: " + result);
        
        scanner.close();
    }
}
