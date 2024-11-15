import java.util.Scanner;

class TreeNode {
    int value;
    TreeNode left, right;

    TreeNode(int x) {
        value = x;
    }
}

public class Problem20 {
    static int findHeight(TreeNode node) {
        if (node == null) return 0;
        return Math.max(findHeight(node.left), findHeight(node.right)) + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode root = new TreeNode(scanner.nextInt());
        buildTree(root, scanner);
        System.out.println("Maximum Depth/Height of the tree: " + findHeight(root));
    }

    static void buildTree(TreeNode node, Scanner scanner) {
        int leftValue = scanner.nextInt();
        if (leftValue != -1) {
            node.left = new TreeNode(leftValue);
            buildTree(node.left, scanner);
        }
        
        int rightValue = scanner.nextInt();
        if (rightValue != -1) {
            node.right = new TreeNode(rightValue);
            buildTree(node.right, scanner);
        }
    }
}
