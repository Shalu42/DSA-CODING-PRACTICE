import java.util.*;

class Problem14 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        int result = 0;
        int sign = 1; // 1 for positive, -1 for negative
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)) {
                currentNumber = currentNumber * 10 + (ch - '0');
            } 
            
            if (ch == '+' || ch == '-' || ch == '(' || ch == ')' || i == s.length() - 1) {
                if (ch == '(') {
                    stack.push(result);
                    stack.push(sign);
                    result = 0;
                    sign = 1;
                } else if (ch == ')') {
                    result += sign * currentNumber;
                    currentNumber = 0;
                    result *= stack.pop();
                    result += stack.pop();
                } else if (ch == '+' || ch == '-') {
                    result += sign * currentNumber;
                    currentNumber = 0;
                    sign = (ch == '+') ? 1 : -1;
                }
            }
        }
        
        result += sign * currentNumber;
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Problem14 obj = new Problem14();
        
        System.out.println("Enter the expression: ");
        String input = scanner.nextLine();
        
        int result = obj.calculate(input);
        System.out.println("Result: " + result);
        
        scanner.close();
    }
}
