import java.util.Scanner;

class Problem4 {
    int transitionPoint(int arr[]) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();  // Read the size of the array
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();  // Read the elements of the array
        }
        
        Problem4 solution = new Problem4();
        System.out.println(solution.transitionPoint(arr));  // Print the result
        
        sc.close();
    }
}
