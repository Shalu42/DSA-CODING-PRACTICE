import java.util.Scanner;

class SegmentTree {
    private int[] tree;
    private int n;

    public SegmentTree(int size) {
        n = size;
        tree = new int[4 * n];
    }

    public void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            build(arr, 2 * node + 1, start, mid);
            build(arr, 2 * node + 2, mid + 1, end);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    public int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return 0;
        }
        if (l <= start && end <= r) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        int leftQuery = query(2 * node + 1, start, mid, l, r);
        int rightQuery = query(2 * node + 2, mid + 1, end, l, r);
        return leftQuery + rightQuery;
    }

    public void update(int node, int start, int end, int idx, int value) {
        if (start == end) {
            tree[node] = value;
        } else {
            int mid = (start + end) / 2;
            if (start <= idx && idx <= mid) {
                update(2 * node + 1, start, mid, idx, value);
            } else {
                update(2 * node + 2, mid + 1, end, idx, value);
            }
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        SegmentTree segmentTree = new SegmentTree(n);
        segmentTree.build(arr, 0, 0, n - 1);

        System.out.println("Segment Tree built successfully.");

        System.out.println("Enter the range for query (l, r):");
        int l = sc.nextInt();
        int r = sc.nextInt();
        int result = segmentTree.query(0, 0, n - 1, l, r);
        System.out.println("Sum of the range [" + l + ", " + r + "] is: " + result);

        System.out.println("Enter index and new value for update (idx, value):");
        int idx = sc.nextInt();
        int value = sc.nextInt();
        segmentTree.update(0, 0, n - 1, idx, value);

        System.out.println("Enter the range for query (l, r) after update:");
        l = sc.nextInt();
        r = sc.nextInt();
        result = segmentTree.query(0, 0, n - 1, l, r);
        System.out.println("Sum of the range [" + l + ", " + r + "] after update is: " + result);

        sc.close();
    }
}
