import java.util.*;

class Problem20 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return nums[left];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Problem20 obj = new Problem20();
        
        System.out.println("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        
        int[] nums = new int[n];
        System.out.println("Enter the array elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        
        int minElement = obj.findMin(nums);
        System.out.println("The minimum element in the array is: " + minElement);
        
        scanner.close();
    }
}
