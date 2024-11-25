import java.util.*;

class BinarySearchTree2 {
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
        else if (key > root.key) root.right = insertRec(root.right, key);
        return root;
    }

    void delete(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        if (root == null) return null;

        if (key < root.key) root.left = deleteRec(root.left, key);
        else if (key > root.key) root.right = deleteRec(root.right, key);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            root.key = findMin(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    int findMin(Node root) {
        while (root.left != null) root = root.left;
        return root.key;
    }

    void inorder() {
        inorderRec(root);
        System.out.println();
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree2 bst = new BinarySearchTree2();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display Inorder Traversal");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int value = scanner.nextInt();
                    bst.insert(value);
                    System.out.println(value + " inserted.");
                    break;
                case 2:
                    System.out.print("Enter value to delete: ");
                    int delValue = scanner.nextInt();
                    bst.delete(delValue);
                    System.out.println(delValue + " deleted.");
                    break;
                case 3:
                    System.out.println("Inorder Traversal:");
                    bst.inorder();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
