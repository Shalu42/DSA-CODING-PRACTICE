import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class ValidateAndPrintBST {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    public TreeNode convertToBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        storeInorder(root, values);
        Collections.sort(values);
        return buildBST(values, 0, values.size() - 1);
    }

    private void storeInorder(TreeNode node, List<Integer> values) {
        if (node == null) return;
        storeInorder(node.left, values);
        values.add(node.val);
        storeInorder(node.right, values);
    }

    private TreeNode buildBST(List<Integer> values, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(values.get(mid));
        node.left = buildBST(values, start, mid - 1);
        node.right = buildBST(values, mid + 1, end);
        return node;
    }

    public void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    public void printTree(TreeNode root, String prefix, boolean isLeft) {
        if (root != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.val);
            printTree(root.left, prefix + (isLeft ? "│   " : "    "), true);
            printTree(root.right, prefix + (isLeft ? "│   " : "    "), false);
        }
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
        ValidateAndPrintBST validator = new ValidateAndPrintBST();

        System.out.println("\nOriginal Tree:");
        validator.printTree(root, "", false);

        if (validator.isValidBST(root)) {
            System.out.println("\nThe given tree is a valid BST.");
        } else {
            System.out.println("\nThe given tree is not a valid BST.");
            root = validator.convertToBST(root);
            System.out.println("\nThe tree has been converted into a valid BST.");
        }

        System.out.println("\nInorder traversal of the BST:");
        validator.inorderTraversal(root);

        System.out.println("\n\nTree Structure:");
        validator.printTree(root, "", false);

        scanner.close();
    }
}
