import java.util.Scanner;

public class problem2 {
    public static int maxOnes(int[][] Mat, int N, int M) {
        int maxRowIndex = -1;
        int maxOnesCount = 0;

        for (int i = 0; i < N; i++) {
            int onesCount = countOnes(Mat[i], M);
            if (onesCount > maxOnesCount) {
                maxOnesCount = onesCount;
                maxRowIndex = i;
            }
        }
        
        return maxRowIndex;
    }

    private static int countOnes(int[] row, int M) {
        int low = 0, high = M - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (row[mid] == 1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return M - low;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of rows (N): ");
        int N = scanner.nextInt();
        System.out.print("Enter the number of columns (M): ");
        int M = scanner.nextInt();

        int[][] Mat = new int[N][M];
        System.out.println("Enter the elements of the matrix row by row:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Mat[i][j] = scanner.nextInt();
            }
        }

        int result = maxOnes(Mat, N, M);
        System.out.println("The row with the maximum number of 1s is: " + result);

        scanner.close();
    }
}
