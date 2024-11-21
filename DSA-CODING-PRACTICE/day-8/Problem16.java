import java.util.*;

class Problem16 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / n][mid % n];
            
            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Problem16 obj = new Problem16();
        
        System.out.println("Enter the number of rows in the matrix: ");
        int m = scanner.nextInt();
        
        System.out.println("Enter the number of columns in the matrix: ");
        int n = scanner.nextInt();
        
        int[][] matrix = new int[m][n];
        
        System.out.println("Enter the matrix values row by row: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        System.out.println("Enter the target value: ");
        int target = scanner.nextInt();
        
        boolean result = obj.searchMatrix(matrix, target);
        System.out.println("Target found: " + result);
        
        scanner.close();
    }
}
