import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class problem5 {
    public static List<String> findPaths(int[][] mat, int n) {
        List<String> paths = new ArrayList<>();
        if (mat[0][0] == 0 || mat[n - 1][n - 1] == 0) {
            return paths;
        }
        boolean[][] visited = new boolean[n][n];
        findPathsUtil(mat, n, 0, 0, "", visited, paths);
        Collections.sort(paths);
        return paths;
    }

    private static void findPathsUtil(int[][] mat, int n, int row, int col, String path, boolean[][] visited, List<String> paths) {
        if (row == n - 1 && col == n - 1) {
            paths.add(path);
            return;
        }

        visited[row][col] = true;

        // Down
        if (isSafe(mat, visited, n, row + 1, col)) {
            findPathsUtil(mat, n, row + 1, col, path + "D", visited, paths);
        }
        // Left
        if (isSafe(mat, visited, n, row, col - 1)) {
            findPathsUtil(mat, n, row, col - 1, path + "L", visited, paths);
        }
        // Right
        if (isSafe(mat, visited, n, row, col + 1)) {
            findPathsUtil(mat, n, row, col + 1, path + "R", visited, paths);
        }
        // Up
        if (isSafe(mat, visited, n, row - 1, col)) {
            findPathsUtil(mat, n, row - 1, col, path + "U", visited, paths);
        }

        visited[row][col] = false;
    }

    private static boolean isSafe(int[][] mat, boolean[][] visited, int n, int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n && mat[row][col] == 1 && !visited[row][col];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the matrix (n): ");
        int n = scanner.nextInt();
        int[][] mat = new int[n][n];

        System.out.println("Enter the matrix elements (0 or 1):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = scanner.nextInt();
            }
        }

        List<String> result = findPaths(mat, n);
        if (result.isEmpty()) {
            System.out.println("-1");
        } else {
            for (String path : result) {
                System.out.print(path + " ");
            }
        }

        scanner.close();
    }
}
