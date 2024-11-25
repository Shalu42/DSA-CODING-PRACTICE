import java.util.*;
import java.util.Scanner;

class Problem1 {

    public static int knapsack(int capacity, int[] val, int[] wt, int n) {
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the capacity of the knapsack: ");
        int capacity = sc.nextInt();
        
        System.out.print("Enter the number of items: ");
        int n = sc.nextInt();
        
        int[] val = new int[n];
        int[] wt = new int[n];
        
        System.out.println("Enter the values of the items: ");
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }
        
        System.out.println("Enter the weights of the items: ");
        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }
        
        int result = knapsack(capacity, val, wt, n);
        System.out.println("Maximum value in knapsack = " + result);
        
        sc.close();
    }
}
