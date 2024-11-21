import java.util.*;

class Problem13 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            if (token.equals("+")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
            } else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if (token.equals("*")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a * b);
            } else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b); // Integer division truncates toward zero
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Problem13 obj = new Problem13();
        
        System.out.println("Enter the tokens (space-separated): ");
        String input = scanner.nextLine();
        String[] tokens = input.split(" ");
        
        int result = obj.evalRPN(tokens);
        System.out.println("Result: " + result);
        
        scanner.close();
    }
}
