import java.util.*;

class Problem12 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public Problem12() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Problem12 minStack = new Problem12();
        
        while (true) {
            System.out.println("Enter operation (push, pop, top, getMin, or exit): ");
            String operation = scanner.nextLine().trim().toLowerCase();

            if (operation.equals("exit")) {
                break;
            }

            switch (operation) {
                case "push":
                    System.out.println("Enter value to push: ");
                    int pushVal = scanner.nextInt();
                    minStack.push(pushVal);
                    System.out.println("Pushed: " + pushVal);
                    scanner.nextLine(); // Consume the newline
                    break;

                case "pop":
                    minStack.pop();
                    System.out.println("Popped top element.");
                    break;

                case "top":
                    System.out.println("Top element: " + minStack.top());
                    break;

                case "getmin":
                    System.out.println("Minimum element: " + minStack.getMin());
                    break;

                default:
                    System.out.println("Invalid operation. Try again.");
            }
        }
        
        scanner.close();
    }
}
