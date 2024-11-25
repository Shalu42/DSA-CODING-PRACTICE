import java.util.*;

class BSTKthLargest {
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

    int findKthLargest(Node root, int[] k) {
        if (root == null) return -1;

        int right = findKthLargest(root.right, k);
        if (right != -1) return right;

        if (--k[0] == 0) return root.key;

        return findKthLargest(root.left, k);
    }

    int kthLargest(int k) {
        return findKthLargest(root, new int[]{k});
    }

    public static void main(String[] args) {
        BSTKthLargest bst = new BSTKthLargest();
        int[] keys = {50, 30, 70, 20, 40, 60, 80};
        for (int key : keys) bst.insert(key);

        System.out.println("3rd Largest: " + bst.kthLargest(3));
    }
}
