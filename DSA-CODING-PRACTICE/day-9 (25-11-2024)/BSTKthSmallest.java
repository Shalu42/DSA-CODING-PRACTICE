import java.util.*;

class BSTKthSmallest {
    class Node {
        int key;
        Node left, right;

        Node(int key) { this.key = key; }
    }

    Node root;

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) return new Node(key);
        if (key < root.key) root.left = insertRec(root.left, key);
        else root.right = insertRec(root.right, key);
        return root;
    }

    int findKthSmallest(Node root, int[] k) {
        if (root == null) return -1;

        int left = findKthSmallest(root.left, k);
        if (left != -1) return left;

        if (--k[0] == 0) return root.key;

        return findKthSmallest(root.right, k);
    }

    int kthSmallest(int k) {
        return findKthSmallest(root, new int[]{k});
    }

    public static void main(String[] args) {
        BSTKthSmallest bst = new BSTKthSmallest();
        int[] keys = {50, 30, 70, 20, 40, 60, 80};
        for (int key : keys) bst.insert(key);

        System.out.println("2nd Smallest: " + bst.kthSmallest(2));
    }
}
