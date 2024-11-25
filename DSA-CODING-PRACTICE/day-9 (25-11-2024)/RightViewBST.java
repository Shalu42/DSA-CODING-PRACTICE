import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class RightViewBST {
    public void printRightView(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (i == size - 1) {
                    System.out.print(current.val + " ");
                }
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
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
        RightViewBST rightView = new RightViewBST();
        System.out.println("Right view of the tree:");
        rightView.printRightView(root);
        scanner.close();
    }
}
