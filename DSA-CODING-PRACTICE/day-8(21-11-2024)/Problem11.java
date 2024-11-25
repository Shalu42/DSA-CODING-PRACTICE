import java.util.*;

public class Problem11 {
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] dirs = path.split("/");

        for (String dir : dirs) {
            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!dir.equals("") && !dir.equals(".")) {
                stack.push(dir);
            }
        }

        StringBuilder result = new StringBuilder();
        if (stack.isEmpty()) {
            result.append("/");
        } else {
            while (!stack.isEmpty()) {
                result.insert(0, "/" + stack.pop());
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the absolute path:");
        String path = sc.nextLine();
        String result = simplifyPath(path);
        System.out.println("The simplified canonical path is: " + result);
    }
}
