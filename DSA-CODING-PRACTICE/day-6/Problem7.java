import java.util.*;

public class Problem7 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes:");
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println("Tree is empty.");
            return;
        }
        System.out.println("Enter the values of the nodes in level-order (use -1 for null):");
        TreeNode root = buildTree(sc, n);
        boolean result = isValidBST(root);
        System.out.println("Is valid BST: " + result);
    }

    public static TreeNode buildTree(Scanner sc, int n) {
        if (n == 0) return null;
        TreeNode root = new TreeNode(sc.nextInt());
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < n; ) {
            TreeNode current = queue.poll();
            int leftVal = sc.nextInt();
            if (leftVal != -1) {
                current.left = new TreeNode(leftVal);
                queue.add(current.left);
            }
            i++;
            if (i < n) {
                int rightVal = sc.nextInt();
                if (rightVal != -1) {
                    current.right = new TreeNode(rightVal);
                    queue.add(current.right);
                }
                i++;
            }
        }
        return root;
    }

    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}
