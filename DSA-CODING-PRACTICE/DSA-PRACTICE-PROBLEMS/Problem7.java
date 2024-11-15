import java.util.*;

public class Problem7{
  public static int minDiff(int[] arr,int m){
      int n=arr.length;
      if(n<m){
         return -1;
      }
      if(n==0||m==0){
         return 0;
      }
      Arrays.sort(arr);
      int mindiff= Integer.MAX_VALUE;
      for(int i =0;i+m-1<n;i++){
          int diff=arr[i+m-1] - arr[i];
          mindiff=Math.min(mindiff,diff);
      }
      return mindiff;
  }
  public static void main(String args[]){
      Scanner scanner = new Scanner(System.in);

      System.out.println("Enter the elements:");
      String inputLine = scanner.nextLine(); 
      String[] inputStrings = inputLine.split(" ");
      int[] arr = new int[inputStrings.length];
      for (int i = 0; i < inputStrings.length; i++) {
            arr[i] = Integer.parseInt(inputStrings[i]); 
       }
      System.out.println("Enter the nuber of students:");
      int m=scanner.nextInt();

      System.out.println("Output: "+ minDiff(arr,m));
      scanner.close();
   }
}
