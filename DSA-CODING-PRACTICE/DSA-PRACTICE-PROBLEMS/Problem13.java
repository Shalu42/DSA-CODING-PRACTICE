import java.util.*;

class Problem13{
    public static String isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()){
                     return "Not Balanced";
                }
                stack.pop();
            }
        }

        return stack.isEmpty() ? "Balanced" : "Not Balanced";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the parentheses expression: ");
        String str = scanner.nextLine();

        System.out.println("The expression is: " + isBalanced(str));
    }
}
