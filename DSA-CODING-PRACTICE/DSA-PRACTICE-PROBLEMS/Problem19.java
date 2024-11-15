import java.util.ArrayList;
import java.util.Scanner;

class TreeNode {
    int value;
    TreeNode left, right;

    TreeNode(int x) {
        value = x;
    }
}

public class Problem19 {
    static void getRightView(TreeNode node, int level, int[] maxLevel, ArrayList<Integer> view) {
        if (node == null) return;
        if (level > maxLevel[0]) {
            view.add(node.value);
            maxLevel[0] = level;
        }
        getRightView(node.right, level + 1, maxLevel, view);
        getRightView(node.left, level + 1, maxLevel, view);
    }

    static ArrayList<Integer> rightView(TreeNode root) {
        ArrayList<Integer> rightSideView = new ArrayList<>();
        getRightView(root, 0, new int[]{-1}, rightSideView);
        return rightSideView;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode root = new TreeNode(scanner.nextInt());
        root.left = new TreeNode(scanner.nextInt());
        root.right = new TreeNode(scanner.nextInt());
        root.right.left = new TreeNode(scanner.nextInt());
        root.right.right = new TreeNode(scanner.nextInt());

        ArrayList<Integer> result = rightView(root);
        result.forEach(v -> System.out.print(v + " "));
    }
}
