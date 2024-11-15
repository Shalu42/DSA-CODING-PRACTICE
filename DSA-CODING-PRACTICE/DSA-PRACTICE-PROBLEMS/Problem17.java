import java.util.*;

class Problem17 {
    public static void deleteMiddle(Stack<Integer> stack, int size, int currentIndex) {
        if (stack.isEmpty() || currentIndex == size) return;
        int element = stack.pop();
        
        deleteMiddle(stack, size, currentIndex + 1);
        
        if (currentIndex != size / 2) {
            stack.push(element);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the stack: ");
        int n = scanner.nextInt();
        
        Stack<Integer> stack = new Stack<>();
        System.out.print("Enter the elements of the stack: ");
        for (int i = 0; i < n; i++) {
            stack.push(scanner.nextInt());
        }
        
        deleteMiddle(stack, n, 0);
        
        System.out.println("Stack after deleting the middle element: " + stack);
    }
}
