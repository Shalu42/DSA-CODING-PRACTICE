import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) { this.val = val; }
}

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    public static TreeNode createTree(Scanner scanner) {
        System.out.print("Enter value (-1 for null): ");
        int val = scanner.nextInt();
        if (val == -1) return null;
        TreeNode node = new TreeNode(val);
        System.out.println("Enter left child of " + val);
        node.left = createTree(scanner);
        System.out.println("Enter right child of " + val);
        node.right = createTree(scanner);
        return node;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Create the binary tree:");
        TreeNode root = createTree(scanner);
        ValidateBST validator = new ValidateBST();
        System.out.println("Is valid BST? " + validator.isValidBST(root));
        scanner.close();
    }
}
