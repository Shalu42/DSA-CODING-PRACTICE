import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BottomViewBST {
    static class Pair {
        TreeNode node;
        int hd;

        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public void printBottomView(TreeNode root) {
        if (root == null) return;
        Map<Integer, Integer> bottomViewMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            bottomViewMap.put(current.hd, current.node.val);
            if (current.node.left != null) queue.add(new Pair(current.node.left, current.hd - 1));
            if (current.node.right != null) queue.add(new Pair(current.node.right, current.hd + 1));
        }
        for (int value : bottomViewMap.values()) {
            System.out.print(value + " ");
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
        BottomViewBST bottomView = new BottomViewBST();
        System.out.println("Bottom view of the tree:");
        bottomView.printBottomView(root);
        scanner.close();
    }
}