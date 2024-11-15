import java.util.HashMap;
import java.util.Scanner;

class Problem3 {

    public static boolean areArraysEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (int num : arr2) {
            if (!map.containsKey(num)) {
                return false;
            }
            int count = map.get(num);
            if (count == 1) {
                map.remove(num);
            } else {
                map.put(num, count - 1);
            }
        }
        
        return map.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the size of the first array: ");
        int n1 = sc.nextInt();
        
        int[] arr1 = new int[n1];
        System.out.println("Enter the elements of the first array: ");
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.print("Enter the size of the second array: ");
        int n2 = sc.nextInt();
        
        int[] arr2 = new int[n2];
        System.out.println("Enter the elements of the second array: ");
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        boolean result = areArraysEqual(arr1, arr2);
        if (result) {
            System.out.println("The arrays are equal.");
        } else {
            System.out.println("The arrays are not equal.");
        }

        sc.close();
    }
}
