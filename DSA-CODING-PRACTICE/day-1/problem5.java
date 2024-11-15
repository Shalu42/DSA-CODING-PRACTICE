import java.util.Scanner;

class Problem5 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // If left or right subtree is unbalanced, return -1
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        // If the current node is unbalanced, return -1
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Return the height of the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static TreeNode buildTree(Scanner sc) {
        System.out.print("Enter the value of the node (-1 for no node): ");
        int val = sc.nextInt();
        if (val == -1) {
            return null;
        }

        TreeNode node = new TreeNode(val);
        System.out.println("Enter left child of " + val + ":");
        node.left = buildTree(sc);
        System.out.println("Enter right child of " + val + ":");
        node.right = buildTree(sc);

        return node;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the binary tree structure:");
        TreeNode root = buildTree(sc);

        if (isBalanced(root)) {
            System.out.println("1");  // The tree is balanced
        } else {
            System.out.println("0");  // The tree is not balanced
        }

        sc.close();
    }
}
