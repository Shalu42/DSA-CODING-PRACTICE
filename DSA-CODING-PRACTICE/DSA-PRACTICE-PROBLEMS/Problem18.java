import java.util.Stack;
import java.util.Scanner;

public class Problem18{
    public static void printNextGreater(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int index = stack.pop();
                System.out.println(arr[index] + " --> " + arr[i]);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            System.out.println(arr[index] + " --> -1");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Next Greater Element for each element in the array:");
        printNextGreater(arr);

        scanner.close();
    }
}
