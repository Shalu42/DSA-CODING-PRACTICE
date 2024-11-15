import java.util.*;

class Problem2{
    public int count(int coins[], int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1; // There's one way to make sum 0, which is using no coins.
        
        for (int coin : coins) {
            for (int i = coin; i <= sum; i++) {
                dp[i] += dp[i - coin];
            }
        }
        
        return dp[sum];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Reading the number of coins
        System.out.print("Enter the number of coins: ");
        int n = sc.nextInt();
        
        // Reading the coin denominations
        int[] coins = new int[n];
        System.out.print("Enter the coin denominations: ");
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        
        // Reading the sum
        System.out.print("Enter the sum: ");
        int sum = sc.nextInt();
        
        Problem2 solution = new Problem2();
        
        // Output the number of ways to make the sum
        System.out.println("Number of ways to make the sum: " + solution.count(coins, sum));
        
        sc.close();
    }
}
