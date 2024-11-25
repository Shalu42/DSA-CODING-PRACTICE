import java.util.*;

class Problem5 {
    int firstRepeatingElement(int arr[]) {
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (seen.contains(arr[i])) {
                return i + 1;
            }
            seen.add(arr[i]);
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        Problem5 solution = new Problem5();
        System.out.println(solution.firstRepeatingElement(arr));
        
        sc.close();
    }
}
