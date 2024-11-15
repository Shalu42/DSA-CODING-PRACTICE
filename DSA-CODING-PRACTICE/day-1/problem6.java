import java.util.Scanner;

class Problem6 {

    public static boolean findTriplet(int[] arr, int n, int x) {
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == x) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.print("Enter the value of x: ");
        int x = sc.nextInt();

        if (findTriplet(arr, n, x)) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }

        sc.close();
    }
}
