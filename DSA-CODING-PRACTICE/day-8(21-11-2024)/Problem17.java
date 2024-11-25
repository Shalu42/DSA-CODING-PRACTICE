import java.util.*;

class Problem17 {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[mid + 1]) {
                right = mid; // Peak is on the left side or at mid
            } else {
                left = mid + 1; // Peak is on the right side
            }
        }
        
        return left; // left will be at the peak element
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Problem17 obj = new Problem17();
        
        System.out.println("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        
        int[] nums = new int[n];
        System.out.println("Enter the array elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        
        int peakIndex = obj.findPeakElement(nums);
        System.out.println("Peak element index: " + peakIndex);
        
        scanner.close();
    }
}
