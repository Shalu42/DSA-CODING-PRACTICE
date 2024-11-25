import java.util.*;

class Problem1{
    ArrayList<ArrayList<Integer>> stockBuySell(int A[], int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int i = 0;
        while (i < n - 1) {
            while (i < n - 1 && A[i] >= A[i + 1]) {
                i++;
            }
            if (i == n - 1) {
                break;
            }
            int buy = i++;
            while (i < n && A[i] >= A[i - 1]) {
                i++;
            }
            int sell = i - 1;
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(buy);
            pair.add(sell);
            result.add(pair);
        }
        if (result.isEmpty()) {
            return new ArrayList<>();
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        Problem1 solution = new Problem1();
        ArrayList<ArrayList<Integer>> result = solution.stockBuySell(prices, n);

        if (result.isEmpty()) {
            System.out.println("No Profit");
        } else {
            for (ArrayList<Integer> pair : result) {
                System.out.println("(" + pair.get(0) + " " + pair.get(1) + ")");
            }
        }

        sc.close();
    }
}
