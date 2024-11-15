import java.util.*;

public class Problem3{
     public static int findKey(int[] arr, int key){
          int index=0;
          for(int i=0;i<arr.length;i++){
              if (arr[i]==key){
                  return i;
              }
          }
          return -1;
      }
      public static void main(String args[]){
          Scanner scanner =new Scanner(System.in);
          System.out.println("Enter the elements:");
          String inputLine = scanner.nextLine(); 
          String[] inputStrings = inputLine.split(" ");
          int[] arr = new int[inputStrings.length];
          for (int i = 0; i < inputStrings.length; i++) {
             arr[i] = Integer.parseInt(inputStrings[i]); 
          }
          System.out.println("Enter the key:");
          int key=scanner.nextInt();
          System.out.println("Output:"+ findKey(arr,key));
          scanner.close();
      }
}
